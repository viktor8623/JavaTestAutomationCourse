package pvt.home.task19.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends Page {

	public ResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='filter_price']/div[2]//a[1]")
	public WebElement filterByPriceFirst;

	@FindBy(xpath = "//div[@id='filter_price']/div[2]//a[last()]")
	public WebElement filterByPriceLast;

	@FindBy(xpath = "//a[@aria-checked='true']//span")
	public WebElement selectedFilter;

	@FindBy(xpath = "//div[contains(@class, 'sr_separator')]")
	public List<WebElement> separators;

	@FindBy(xpath = "//div[contains(@class, 'sr_separator')]/preceding-sibling::div[normalize-space(@class)='sr_item sr_item_new sr_item_default sr_property_block sr_flex_layout']")
	public List<WebElement> listOfResultsAboveSeparator;

	@FindBy(xpath = "//div[normalize-space(@class)='sr_item sr_item_new sr_item_default sr_property_block sr_flex_layout']")
	public List<WebElement> listOfResults;

	@FindBy(xpath = "//div[normalize-space(@class)='sr_item sr_item_new sr_item_default sr_property_block sr_flex_layout'][1]")
	public WebElement firstResult;

	@FindBy(xpath = ".//b[@class='sr_gs_price_total']")
	public WebElement availableRoomsButton;

	@FindBy(xpath = "//button[@id='sortbar_dropdown_button']")
	public List<WebElement> threeDotsButton;

	@FindBy(xpath = "//a[@data-category='bayesian_review_score']")
	public WebElement topReviewed;

	@FindBy(xpath = "//a[@data-category='price']")
	public WebElement lowestPriceFirst;

	public ArrayList<String> getListOfPrices(WebElement resultBlock) {
		ArrayList<String> textsOfResults = new ArrayList<>();
		List<WebElement> results = resultBlock.findElements(By.xpath(".//strong/div/b"));
		if (results.size() == 0) {
			results = resultBlock.findElements(By.xpath(".//strong/b"));
		}
		for (WebElement result : results) {
			String text = result.getText();
			textsOfResults.add(text);
		}
		return textsOfResults;
	}

	public void clickAvailableRooomsButton(WebElement resultBlock) {
		resultBlock.findElement(By.xpath(".//a[contains(@class, 'b-button')]")).click();
	}

	public void waitForUpdate() {
		fluentWait.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				List<WebElement> alerts = driver
						.findElements(By.xpath("//div[@class='sr-usp-overlay sr-usp-overlay--wide']"));
				if (alerts.size() == 0) {
					return true;
				}
				return false;
			}
		});
	}
}
