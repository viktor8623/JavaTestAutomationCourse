package pvt.home.task19.tests;

import org.testng.annotations.BeforeMethod;

import pvt.home.task19.app.Application;

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

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }
}
