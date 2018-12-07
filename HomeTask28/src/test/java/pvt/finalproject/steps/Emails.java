package pvt.finalproject.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pvt.finalproject.pages.EmailPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class Emails {
    private WebDriver driver;
    private EmailPage emailPage;

    public Emails(WebDriver driver) {
        this.driver = driver;
        emailPage = new EmailPage(driver);
    }

    public void moveFirstMessageToSpam() {
        int messagesCountBefore = emailPage.messages.size();
        emailPage.firstCheckbox.click();
        emailPage.spamButton.click();
        emailPage.waitForNotification();
        int messagesCountAfter = emailPage.messages.size();
        assertEquals(messagesCountBefore - 1, messagesCountAfter);
    }

    public void verifyNotificationMoveToSpam() {
        verifyNotification("Письмо перемещено в папку «Спам». Отменить");
    }

    public void verifyNotificationMoveToInbox() {
        verifyNotification("Письмо перемещено в папку «Входящие»");
    }

    public void verifyNotificationEmailSent() {
        String notificationText = emailPage.notificationAfterSend.getText();
        String expectedNotification = "Ваше письмо отправлено. Перейти во Входящие";
        assertEquals(notificationText, expectedNotification);
    }


    public void verifyNotification(String expectedText) {
        assertEquals(expectedText, emailPage.notification.getText().trim());
    }

    public void markMessageAsNotSpam() {
        emailPage.spamTab.click();
        emailPage.waitForVisibility(emailPage.firstCheckbox);
        emailPage.firstCheckbox.click();
        int messagesCountBefore = emailPage.messages.size();
        emailPage.notSpamButton.click();
        emailPage.waitForMessageDisappearance(emailPage.messages.size());
        emailPage.waitForNotification();
        int messagesCountAfter = emailPage.messages.size();
        assertEquals(messagesCountBefore - 1, messagesCountAfter);
    }

    public void sentMessage(String subject, String text, String...receivers) {
        emailPage.writeLetter.click();
        for (String receiver : receivers) {
            emailPage.toInput.sendKeys(receiver + ",");
        }
        emailPage.subjectInput.sendKeys(subject);
        emailPage.enterMessage(text);
        emailPage.sendButton.click();
    }

    public void verifySending(String[] receivers) {
        verifyNotificationEmailSent();
        String[] actualListOfReceivers = emailPage.listOfReceivers.getText().split(", ");
        assertArrayEquals(receivers, actualListOfReceivers);
    }

    public void flagMessagesStartTop(int quantity) {
        emailPage.inboxTab.click();
        List<WebElement> messages = emailPage.messages;
        for (int row = 0; row < quantity; row++) {
            emailPage.markWithFlag(messages.get(row));
        }
    }

    public void removeAllFlags() {
        emailPage.checkAll.click();
        emailPage.moreButton.click();
        emailPage.removeFlagOption.click();
    }

    public void verifyNoFlags() {
        assertEquals(0, emailPage.flags.size());
    }
}
