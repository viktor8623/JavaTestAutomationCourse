package pvt.home.task20.tests;

import org.testng.annotations.Test;


public class MailRuTests extends TestBase {

    @Test(priority = 1)
    public void testMoveMessageToSpam() {
        app.moveFirstMessageToSpam();
        app.verifyNotification("Письмо перемещено в папку «Спам». Отменить");
    }

    @Test(priority = 2)
    public void testNotSpam() {
        app.markAsNotSpam();
        app.verifyNotification("Письмо перемещено в папку «Входящие»");
    }

    @Test(priority = 3)
    public void testSendMessageToMultipleReceivers() {
        app.sentMessage("Test", "Some text...", "test@mailinator.com", "test2@mailinator.com",
                "test3@mailinator.com");
        app.verifySending("Ваше письмо отправлено. Перейти во Входящие", "test@mailinator.com",
                "test2@mailinator.com", "test3@mailinator.com");
    }

    @Test(priority = 4)
    public void testFlags() {
        app.flagMessagesStartTop(3);
        app.removeAllFlags();
        app.verifyNoFlags();
    }
}
