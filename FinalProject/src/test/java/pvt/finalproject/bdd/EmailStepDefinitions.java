package pvt.finalproject.bdd;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import pvt.finalproject.appmanager.ApplicationManager;
import pvt.finalproject.appmanager.DriverType;
import pvt.finalproject.model.Email;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EmailStepDefinitions {
    public ApplicationManager app;
    private static final String URL = "https://mail.ru/";
    private static final int USER_ID = 1;
    private String messagesSubject;

    @Before
    public void setUp() throws SQLException {
        app = ApplicationManager.getInstance(DriverType.CHROME);
        if (!app.session.isLoggedIn()) {
            app.session.logIn(URL, USER_ID);
        }
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }

    @AfterStep
    public void makeScreenshot(Scenario scenario){
        app.makeScreenshot();
    }

    @And("^Go to Inbox folder$")
    @Given("^I am in Inbox folder$")
    public void goToInbox() {
        app.emails.goToInbox();
    }

    @And("^I have remembered the subject of the first email")
    public void getSubjectFirstMessage() {
        messagesSubject = app.emails.getMessagesSubject(0);
    }

    @When("^I mark the first email as Spam$")
    public void markAsSpam() {
        app.emails.moveMessageToSpam(0);
        app.emails.verifyNotificationMoveToSpam();
    }

    @When("^I mark first email as NOT Spam$")
    public void markAsNotSpam() {
        app.emails.markMessageAsNotSpam(0);
        app.emails.verifyNotificationMoveToInboxFromSpam();
    }

    @When("^I delete the first email$")
    public void deleteFirstMessage() {
        app.emails.moveMessageToTrash(0);
        app.emails.verifyNotificationMoveToTrash();
    }

    @When("^I click Clear Trash folder link$")
    public void clearTrashFolder() {
        app.emails.clearTrashFolder();
        app.emails.verifyNotificationClearTrashFolder();
    }

    @When("^I mark first \"([^\"]*)\" emails with a flag$")
    public void markEmailsWithFlag(int quantity) {
        app.emails.flagMessagesStartTop(quantity);
    }

    @When("^I mark first \"([^\"]*)\" emails as unread$")
    public void markEmailsAsUnread(int quantity) {
        app.emails.markEmailsUnread(quantity);
    }

    @Then("^I remove unread marks from first \"([^\"]*)\" emails$")
    public void markEmailsAsRead(int quantity) {
        app.emails.markEmailsUnread(quantity);
    }

    @And("^Remove all flags$")
    public void removeAllFlags() {
        app.emails.removeAllFlags();
    }

    @And("^Move the first email to Inbox$")
    public void moveToInbox() {
        app.emails.moveMessageToInbox(0);
        app.emails.verifyNotificationMoveToInboxFromSpam();
    }

    @And("^I move the first email from Inbox from Trash$")
    public void moveToInboxFromTrash() {
        app.emails.moveMessageToInbox(0);
        app.emails.verifyNotificationMoveToInboxFromTrash();
    }

    @And("^Go to Spam folder$")
    public void goToSpam() {
        app.emails.goToSpam();
    }

    @And("^Go to Trash folder$")
    public void goToTrash() {
        app.emails.goToTrash();
    }

    @And("^Go to Sent folder$")
    public void goToSent() {
        app.emails.goToSent();
    }

    @Then("^The email with the same subject is in the folder$")
    public void verifyMessagesSubject() {
        app.emails.verifyMessagesSubjectIsInList(messagesSubject);
    }

    @Then("^The email with the same subject is not in the folder$")
    public void verifyMessageIsNotInList() {
        app.emails.verifyMessagesSubjectIsNotInList(messagesSubject);
    }

    @When("^I send new email with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void sendEmail(String receiver, String subject, String text) {
        app.emails.clickWriteNewMessageButton();
        app.emails.fillOutEmailDetailsOneReceiver(subject, text, receiver);
        app.emails.clickSendEmailButton();
        app.emails.verifySending(receiver);
    }

    @Then("^The email with \"([^\"]*)\" is in the first row$")
    public void verifySendingEmail(String expectedSubject) {
        String actualSubject = app.emails.getMessagesSubject(0);
        assertTrue(actualSubject.contains(expectedSubject));
    }

    @Then("^I send new email from data base to multiple receivers$")
    public void sendEmailToMultipleUsers() throws SQLException {
        Email email = app.db.getEmails();
        app.emails.sentMessage(email.getSubject(), email.getText(), email.getReceivers());
        app.emails.verifySending(email.getReceivers());
    }

    @Then("^The folder is empty$")
    public void verifyFolderIsEmpty() {
        assertTrue(app.emails.isFolderEmpty());
    }

    @Then("^There are no emails marked with a flag$")
    public void verifyNoFlags() {
        app.emails.verifyNoFlags();
    }

    @Then("^I see that counter of unread emails in nav bar has value \"([^\"]*)\"$")
    public void verifyCounterUnreadEmails(int expectedValue) {
        int actualValue = app.emails.getAmountUnreadEmails();
        assertEquals(actualValue, expectedValue);
    }

    @Then("^I see that counter unread emails is not displayed$")
    public void counterUnreadEmailsNotDisplayed() {
        RuntimeException exception = null;
        try {
            app.emails.getAmountUnreadEmails();
        } catch (NoSuchElementException e) {
            exception = e;
        }
        assertEquals(exception.getClass(), NoSuchElementException.class);
    }
}
