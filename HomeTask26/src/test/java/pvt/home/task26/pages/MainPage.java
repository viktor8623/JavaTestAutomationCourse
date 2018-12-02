package pvt.home.task26.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

	public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='mailbox:login']")
    public WebElement emailInput;

    @FindBy(xpath = "//select[@id='mailbox:domain']")
    public WebElement domainSelect;

    @FindBy(xpath = "//input[@id='mailbox:password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Войти']")
    public WebElement logInButton;

    public void open(String url) {
        driver.get(url);
    }
}
