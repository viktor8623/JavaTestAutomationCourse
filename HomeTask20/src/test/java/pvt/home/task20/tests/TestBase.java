package pvt.home.task20.tests;

import org.testng.annotations.BeforeMethod;
import pvt.home.task20.app.Application;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @BeforeMethod
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);
        app.goToMainPage("https://mail.ru/");
        app.logIn("automation.test", "@bk.ru", "!@#QWE123qwe");

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }
}
