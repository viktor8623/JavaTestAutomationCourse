package pvt.home.task19.pages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends Page {

	public OrderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(), 'reserve')]")
	public WebElement reserveButton;

	@FindBy(xpath = "(//td//select)[1]")
	public WebElement roomsSelect;

	@FindBy(xpath = "//input[@id='lastname']")
	public WebElement lastNameInput;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailInput;

	@FindBy(xpath = "//input[@id='email_confirm']")
	public WebElement confirmEmailInput;

	@FindBy(xpath = "//button[@name='book']")
	public WebElement finalDetailsButton;

	@FindBy(xpath = "//input[@id='address1']")
	public WebElement addressInput;

	@FindBy(xpath = "//input[@id='address1']")
	public List<WebElement> addressInputs;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement cityInput;

	@FindBy(xpath = "//input[@id='phone']")
	public WebElement phoneInput;

	@FindBy(xpath = "//input[@value='pay-now']")
	public WebElement payNowCheckbox;

	@FindBy(xpath = "//select[@id='cc_type']")
	public WebElement ccTypeSelect;

	@FindBy(xpath = "//input[@id='cc_number']")
	public WebElement ccNumberInput;

	@FindBy(xpath = "//select[@id='cc_month']")
	public WebElement expMonthSelect;

	@FindBy(xpath = "//select[@id='ccYear']")
	public WebElement expYearSelect;

	@FindBy(xpath = "//input[@id='cc_cvc']")
	public WebElement cvcCodeInput;

	@FindBy(xpath = "//button[contains(@class, 'bp-overview-buttons-submit')]")
	public WebElement compliteBookingButton;

	public WebElement waitForAlert() {
		WebElement waitingAlert = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//p[text()='Please try using a different credit card.']"));
			}
		});
		return waitingAlert;
	}
}
