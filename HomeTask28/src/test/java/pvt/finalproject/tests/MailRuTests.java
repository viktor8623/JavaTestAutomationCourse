package pvt.finalproject.tests;

import org.testng.annotations.Test;
import pvt.finalproject.data.DataProviders;
import pvt.finalproject.model.Email;


public class MailRuTests extends TestBase {

    @Test(priority = 1)
    public void testMoveMessageToSpam() {
        app.emails.moveFirstMessageToSpam();
        app.emails.verifyNotificationMoveToSpam();
    }

    @Test(priority = 2)
    public void testNotSpam() {
        app.emails.markMessageAsNotSpam();
        app.emails.verifyNotificationMoveToInbox();
    }

    @Test(priority = 3, dataProvider = "Emails", dataProviderClass = DataProviders.class)
    public void testSendMessageToMultipleReceivers(Email email) {
        app.emails.sentMessage(email.getSubject(), email.getText(), email.getReceivers());
        app.emails.verifySending(email.getReceivers());
    }

    @Test(priority = 4)
    public void testFlags() {
        app.emails.flagMessagesStartTop(3);
        app.emails.removeAllFlags();
        app.emails.verifyNoFlags();
    }
}
