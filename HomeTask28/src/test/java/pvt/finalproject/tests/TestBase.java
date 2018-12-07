package pvt.finalproject.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pvt.finalproject.app.Application;
import pvt.finalproject.app.DriverType;

import java.sql.SQLException;


public class TestBase {
    public Application app;
    private static final String URL = "https://mail.ru/";
    private static final int USER_ID = 1;

    @BeforeMethod
    public void start() throws SQLException {
        app = Application.getInstance(DriverType.CHROME);
        if (!app.session.isLoggedIn()) {
            app.session.logIn(URL, USER_ID);
        }
    }

    @AfterClass
    public void shutDown() {
        app.quit();
    }
}
