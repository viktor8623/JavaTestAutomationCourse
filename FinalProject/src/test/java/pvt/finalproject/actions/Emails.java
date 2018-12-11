package pvt.finalproject.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pvt.finalproject.pages.EmailPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class Emails {
    private WebDriver driver;
    private EmailPage emailPage;

    public Emails(WebDriver driver) {
        this.driver = driver;
        emailPage = new EmailPage(driver);
    }

    public void goToInbox() {
        if (!driver.getCurrentUrl().contains("inbox")) {
            emailPage.smartClick(emailPage.goToInboxLink);
        }
    }

    public void goToSpam() {
        emailPage.smartClick(emailPage.goToSpamLink);
    }

    public void goToTrash() {
        emailPage.smartClick(emailPage.goToTrashLink);
    }

    public void goToSent() {
        emailPage.smartClick(emailPage.goToSentLink);
    }

    public void moveMessageToSpam(int index) {
        WebElement message = emailPage.messages.get(index);
        emailPage.firstCheckbox.click();
        emailPage.spamButton.click();
        emailPage.waitForElementDisappearance(message);
    }

    public void moveMessageToTrash(int index) {
        WebElement message = emailPage.messages.get(index);
        emailPage.firstCheckbox.click();
        emailPage.removeButton.click();
        emailPage.waitForElementDisappearance(message);
    }

    public void moveMessageToInbox(int index) {
        WebElement message = emailPage.messages.get(index);
        emailPage.getCheckbox(message).click();
        emailPage.moveToButton.click();
        emailPage.moveToInbox.click();
        emailPage.waitForElementDisappearance(message);
    }

    public String getMessagesSubject(int indexNumber) {
        WebElement message = emailPage.messages.get(indexNumber);
        return emailPage.getSubject(message).getText();
    }

    public void verifyMessagesSubjectIsInList(String expectedSubject) {
        emailPage.waitForMessagesDisplayed();
        String actualSubject = "";
        for (WebElement message : emailPage.messages) {
            String subject = emailPage.getSubject(message).getText();
            if (subject.equals(expectedSubject)) {
                actualSubject = subject;
            }
        }
        assertEquals(actualSubject, expectedSubject);
    }

    public void verifyMessagesSubjectIsNotInList(String targetSubject) {
        emailPage.waitForMessagesDisplayed();
        assertFalse(emailPage.messages.stream()
                .anyMatch(message -> (emailPage.getSubject(message)).getText().equals(targetSubject)));
    }

    public void markMessageAsNotSpam(int index) {
        WebElement message = emailPage.messages.get(index);
        emailPage.getCheckbox(message).click();
        emailPage.notSpamButton.click();
        emailPage.waitForElementDisappearance(message);
    }

    public void clearTrashFolder() {
        emailPage.smartClick(emailPage.clearTrashFolderLink);
        emailPage.clearButtonInBalloon.click();
    }

    public boolean isFolderEmpty() {
        emailPage.emptyBlockInMainWindow.isDisplayed();
        return emailPage.messages.size() == 0;
    }

    public void clickWriteNewMessageButton() {
        emailPage.writeLetter.click();
    }

    public void fillOutEmailDetails(String subject, String text, String...receivers) {
        for (String receiver : receivers) {
            emailPage.toInput.sendKeys(receiver + ",");
        }
        emailPage.subjectInput.sendKeys(subject);
        emailPage.enterMessage(text);
    }

    public void fillOutEmailDetailsOneReceiver(String subject, String text, String receiver) {
        emailPage.toInput.sendKeys(receiver);
        emailPage.subjectInput.sendKeys(subject);
        emailPage.enterMessage(text);
    }

    public void clickSendEmailButton() {
        emailPage.sendButton.click();
    }

    public void sentMessage(String subject, String text, String...receivers) {
        clickWriteNewMessageButton();
        fillOutEmailDetails(subject, text, receivers);
        clickSendEmailButton();
    }

    public void flagMessagesStartTop(int quantity) {
        List<WebElement> messages = emailPage.messages;
        for (int i = 0; i < quantity; i++) {
            emailPage.getFlag(messages.get(i)).click();
        }
    }

    public void removeAllFlags() {
        emailPage.checkAll.click();
        emailPage.moreButton.click();
        emailPage.removeFlagOption.click();
        emailPage.checkAll.click();
    }

    public void verifySending(String[] receivers) {
        verifyNotificationEmailSent();
        String[] actualListOfReceivers = emailPage.listOfReceivers.getText().split(", ");
        assertArrayEquals(receivers, actualListOfReceivers);
    }

    public void verifySending(String receiver) {
        verifyNotificationEmailSent();
        String actualReceiver = emailPage.listOfReceivers.getText();
        assertEquals(actualReceiver, receiver);
    }

    public void verifyNoFlags() {
        List<WebElement> emails = emailPage.messages;
        for (WebElement email : emails) {
            assertTrue(!emailPage.isFlagged(emailPage.getFlag(email)),
                    "Email is marked with a flag but should not.");
        }
    }

    public void verifyNotificationMoveToSpam() {
        verifyNotification("Письмо перемещено в папку «Спам». Отменить");
    }

    public void verifyNotificationMoveToInboxFromSpam() {
        verifyNotification("Письмо перемещено в папку «Входящие»");
    }

    public void verifyNotificationMoveToTrash() {
        verifyNotification("Удалено 1 письмо. Отменить");
    }

    public void verifyNotificationMoveToInboxFromTrash() {
        verifyNotification("Письмо перемещено в папку «Входящие». Отменить");
    }

    public void verifyNotificationClearTrashFolder() {
        verifyNotification("Письма удалены");
    }

    public void verifyNotification(String expectedText) {
        emailPage.waitForNotification(expectedText);
        assertEquals(emailPage.notifications.get(0).getText().trim(), expectedText);
    }

    public void verifyNotificationEmailSent() {
        String notificationText = emailPage.notificationAfterSend.getText();
        String expectedNotification = "Ваше письмо отправлено. Перейти во Входящие";
        assertEquals(notificationText, expectedNotification);
    }

    public void markEmailsUnread(int quantity) {
        List<WebElement> messages = emailPage.messages;
        for(int i = 0; i < quantity; i++) {
            emailPage.getStatusMark(messages.get(i)).click();
        }
    }

    public int getAmountUnreadEmails() {
        return Integer.parseInt(emailPage.unreadEmailsCounter.getText());
    }
}
