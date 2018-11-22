package pvt.home.task22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement cityInput;

    @FindBy(xpath = "//div[@class='xp__dates xp__group']")
    private WebElement calendar;

    @FindBy(xpath = "//button/span[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='hotellist_inner']//a[contains(@class, 'b-button')]")
    private List<WebElement> listOfResults;

    @FindBy(xpath = "//a[@data-category='review_score_and_price']")
    private WebElement sortByScore;

    @FindBy(xpath = "//div[@id='js--hp-gallery-scorecard']//div[@class='bui-review-score__badge']")
    private WebElement ratingValue;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findDeals(String city, int deltaForDate) {
        selectCity(city);
        selectDate(deltaForDate);
        clickSearchButton();
    }

    public void selectCity(String city) {
		cityInput.clear();
		cityInput.sendKeys(city);
	}

    public void selectDate(int delta) {
        calendar.click();
        String date = getFutureDate(delta);
		String locatorForDate = String.format("//td[@data-date='%s']", date);
		driver.findElement(By.xpath(locatorForDate)).click();
	}

    public void clickSearchButton() {
        searchButton.click();
	}

    public int getNumberOfResults() {
        return listOfResults.size();
	}

    public void sortDataByScore() {
        sortByScore.click();
        waitForUpdatingResults();
	}

    private void waitForUpdatingResults() {
        WebElement firstResult = listOfResults.get(0);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.stalenessOf(firstResult));
    }

    public void selectTopResult() {
        listOfResults.get(0).click();
        switchToNewTab();
	}

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public double getRating() {
		return Double.parseDouble(ratingValue.getText());
	}
	
	private static String getFutureDate(int delta) {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).plusDays(delta).toString();
	}
}
