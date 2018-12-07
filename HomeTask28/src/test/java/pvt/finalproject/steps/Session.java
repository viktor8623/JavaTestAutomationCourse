package pvt.finalproject.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pvt.finalproject.app.Dbhelper;
import pvt.finalproject.pages.MainPage;

import java.sql.SQLException;

public class Session {
    private WebDriver driver;
    private Dbhelper db;
    private MainPage mainPage;

    public Session(WebDriver driver, Dbhelper db) {
        this.driver = driver;
        this.db = db;
        mainPage = new MainPage(driver);
    }

    public void logIn(String url, int user_id) throws SQLException {
        goToMainPage(url);
        loginAsUser(user_id);
    }

    private void goToMainPage(String url) {
        mainPage.open(url);
    }

    private void loginAsUser(int user_id) throws SQLException {
        String[] credentials = db.getCredentials(user_id);
        enterCredentials(credentials[0], credentials[1], credentials[2]);
    }

    private void enterCredentials(String email, String domain, String password) {
        mainPage.emailInput.sendKeys(email);
        new Select(mainPage.domainSelect).selectByVisibleText(domain);
        mainPage.passwordInput.sendKeys(password);
        mainPage.logInButton.click();
    }

    public boolean isLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("messages") || currentUrl.contains("addressbook") ||
                currentUrl.contains("filesearch") || currentUrl.contains("settings") || currentUrl.contains("send");
    }
}
