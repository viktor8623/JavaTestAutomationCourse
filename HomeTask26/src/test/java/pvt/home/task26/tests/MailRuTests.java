package pvt.home.task26.tests;

import org.testng.annotations.Test;
import pvt.home.task26.data.DataProviders;
import pvt.home.task26.model.Email;


public class MailRuTests extends TestBase {

    @Test(priority = 1)
    public void testMoveMessageToSpam() {
        app.moveFirstMessageToSpam();
        app.verifyNotificationMoveToSpam();
    }

    @Test(priority = 2)
    public void testNotSpam() {
        app.markAsNotSpam();
        app.verifyNotificationMoveToInbox();
    }

    @Test(priority = 3, dataProvider = "Emails", dataProviderClass = DataProviders.class)
    public void testSendMessageToMultipleReceivers(Email email) {
        app.sentMessage(email.getSubject(), email.getText(), email.getReceivers());
        app.verifySending(email.getReceivers());
    }

    @Test(priority = 4)
    public void testFlags() {
        app.flagMessagesStartTop(3);
        app.removeAllFlags();
        app.verifyNoFlags();
    }
}
