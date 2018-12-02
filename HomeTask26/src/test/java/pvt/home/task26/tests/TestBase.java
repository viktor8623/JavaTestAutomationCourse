package pvt.home.task26.tests;

import org.testng.annotations.BeforeMethod;
import pvt.home.task26.app.Application;

import java.sql.SQLException;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @BeforeMethod
    public void start() throws SQLException {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);
        app.goToMainPage("https://mail.ru/");
        app.loginAsUser(1);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }
}
