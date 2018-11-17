package pvt.home.task19.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar extends Page {

	public SearchBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//input[@type='search']")
    public WebElement cityInput;
	
	@FindBy(xpath="//div[@class='xp__dates xp__group']")
    public WebElement datepicker;
	
	@FindBy(xpath="//label[@id='xp__guests__toggle']")
    public WebElement guestsDropDown;
	
	@FindBy(xpath="//button/span[text()='Search']")
    public WebElement searchButton;
	
	//	Guests and rooms with + / - buttons.
	
	@FindBy(xpath="//div[contains(@class, 'sb-group__field-rooms')]//button[1]")
    public WebElement roomsMinusButton;
	
	@FindBy(xpath="//div[contains(@class, 'sb-group__field-rooms')]//button[2]")
    public WebElement roomsPlusButton;
	
	@FindBy(xpath="//div[contains(@class, 'sb-group__field-rooms')]//span[contains(@class, 'display')]")
    public WebElement roomsCount;
	
	@FindBy(xpath="//label[text()='Adults']/../..//button[1]")
    public WebElement adultsMinusButton;
	
	@FindBy(xpath="//label[text()='Adults']/../..//button[2]")
    public WebElement adultsPlusButton;
	
	@FindBy(xpath="//label[text()='Adults']/../..//span[contains(@class, 'display')]")
    public WebElement adultsCount;
	
	@FindBy(xpath="//div[contains(@class, 'sb-group-children')]//button[1]")
    public WebElement childrenMinusButton;
	
	@FindBy(xpath="//div[contains(@class, 'sb-group-children')]//button[2]")
    public WebElement childrenPlusButton;
	
	@FindBy(xpath="//div[contains(@class, 'sb-group-children')]//span[contains(@class, 'display')]")
    public WebElement childrenCount;
	
	//	Guests and rooms with selects.
	
	@FindBy(xpath="//select[@id='no_rooms']")
    public WebElement roomsSelect;
	
	@FindBy(xpath="//select[@id='no_rooms']")
    public List<WebElement> roomsSelects;
	
	@FindBy(xpath="//select[@id='group_adults']")
    public WebElement adultsSelect;
	
	@FindBy(xpath="//select[@id='group_children']")
    public WebElement childrenSelect;
	
	public void pickDate(String date) {
		String checkInOutDate = String.format("//td[@data-date='%s']", date);
		boolean isSelected = driver.findElement(By.xpath(checkInOutDate)).getAttribute("class").contains("selected");
		if (!isSelected) {
			driver.findElement(By.xpath(checkInOutDate)).click();
		}
	}
	
	
	
	
	
	
}
