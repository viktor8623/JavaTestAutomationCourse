package pvt.home.task20.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pvt.home.task20.pages.EmailPage;
import pvt.home.task20.pages.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class Application {

    private WebDriver driver;

    private MainPage mainPage;
    private EmailPage emailPage;


    public Application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        emailPage = new EmailPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void goToMainPage(String url) {
        mainPage.open(url);
    }

    public void logIn(String email, String domain, String password) {
        mainPage.emailInput.sendKeys(email);
        new Select(mainPage.domainSelect).selectByVisibleText(domain);
        mainPage.passwordInput.sendKeys(password);
        mainPage.logInButton.click();
    }

    public void moveFirstMessageToSpam() {
        int messagesCountBefore = emailPage.messages.size();
        emailPage.firstCheckbox.click();
        emailPage.spamButton.click();
        emailPage.waitForNotification();
        int messagesCountAfter = emailPage.messages.size();
        assertEquals(messagesCountBefore - 1, messagesCountAfter);
    }

    public void verifyNotification(String expectedText) {
        assertEquals(expectedText, emailPage.notification.getText().trim());
    }

    public void markAsNotSpam() {
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

    public void verifySending(String expectedNotification, String...receivers) {
        String notificationText = emailPage.notificationAfterSend.getText();
        assertEquals(expectedNotification, notificationText);
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
