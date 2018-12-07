package pvt.finalproject.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import pvt.finalproject.steps.Emails;
import pvt.finalproject.steps.Session;

import java.util.concurrent.TimeUnit;


public class Application {
    private static volatile Application instanceOfApp;
    private static volatile WebDriver driver;
    public Session session;
    public Emails emails;

    private Application(DriverType type) {
        Dbhelper db = new Dbhelper();
        driver = DriverFactory.getDriver(type);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        session = new Session(driver, db);
        emails = new Emails(driver);
    }

    public static Application getInstance(DriverType type) {
        if (instanceOfApp == null || driverIsInvalid()) {
            synchronized (Application.class) {
                if (instanceOfApp == null || driverIsInvalid()) {
                    instanceOfApp = new Application(type);
                }
            }
        }
        return instanceOfApp;
    }

    private static boolean driverIsInvalid() {
        try {
            driver.getCurrentUrl();
            return false;
        } catch (WebDriverException e) {
            return true;
        }
    }

    public void quit() {
        driver.quit();
    }
}
