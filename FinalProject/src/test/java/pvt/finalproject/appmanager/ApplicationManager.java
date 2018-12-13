package pvt.finalproject.appmanager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import pvt.finalproject.actions.Emails;
import pvt.finalproject.actions.Session;
import pvt.finalproject.parsermanager.ParserManager;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    private static volatile ApplicationManager instanceOfApp;
    private static volatile WebDriver driver;
    public Session session;
    public Emails emails;
    public Dbhelper db;
    public ParserManager xmlParser;

    private ApplicationManager(DriverType type) {
        db = new Dbhelper();
        driver = DriverFactory.getDriver(type);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        session = new Session(driver, db);
        emails = new Emails(driver);
        xmlParser = new ParserManager();
    }

    public static ApplicationManager getInstance(DriverType type) {
        if (instanceOfApp == null || driverIsInvalid()) {
            instanceOfApp = new ApplicationManager(type);
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

    @Attachment(value = "Attachment: Screenshot of failure", type = "image/png")
    public byte[] takeScreenshot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void quit() {
        session.logOut();
        driver.quit();
    }
}
