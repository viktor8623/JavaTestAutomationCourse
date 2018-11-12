package pvt.home.task18;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BookingTests {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@DataProvider(name = "testData")
	public static Object[][] testDataBuilder() {
		return new Object[][] {
			{new SearchQuery("1", "Moscow", getFutureDate(1), 9)},
			{new SearchQuery("2", "Moscow", getFutureDate(2), 9)},
			{new SearchQuery("3", "Moscow", getFutureDate(3), 9)},
			{new SearchQuery("4", "Moscow", getFutureDate(4), 9)},
			{new SearchQuery("5", "Moscow", getFutureDate(5), 9)},
			{new SearchQuery("6", "Moscow", getFutureDate(6), 9)},
			{new SearchQuery("7", "Moscow", getFutureDate(7), 9)},
			{new SearchQuery("8", "Moscow", getFutureDate(8), 9)},
			{new SearchQuery("9", "Moscow", getFutureDate(9), 9)},
			{new SearchQuery("10", "Moscow", getFutureDate(10), 9)},
			{new SearchQuery("11", "Moscow", getFutureDate(15), 9)},
			{new SearchQuery("12", "Moscow", getFutureDate(20), 9)},
			{new SearchQuery("13", "Moscow", getFutureDate(25), 9)},
			{new SearchQuery("14", "Moscow", getFutureDate(30), 9)},
			{new SearchQuery("15", "Moscow", getFutureDate(35), 9)},
			{new SearchQuery("16", "Moscow", getFutureDate(40), 9)}
		};
	}
	
	@Test(dataProvider = "testData")
	public void testAvailableHotels(SearchQuery query) {
		goToMainPage();
		selectCity(query.city);
		selectDate(query.date);
		guestsVerifyDefaultValues("2 adults", "0 children", "1");
		clickSearchButton();
		verifySearchResults();
	}
	
	@Test(dataProvider = "testData")
	public void testRatingOfTheFirstSearchResult(SearchQuery query) {
		goToMainPage();
		selectCity(query.city);
		selectDate(query.date);
		guestsVerifyDefaultValues("2 adults", "0 children", "1");
		clickSearchButton();
		sortDataByScore();
		selectTopResult();
		retingBiggerThen(query.rating);
		closeAditionalTabs();
	}
	
	private void goToMainPage() {
		driver.get("https://www.booking.com/");
	}

	private void selectCity(String city) {
		WebElement cityInput = driver.findElement(By.xpath("//input[@type='search']"));
		cityInput.clear();
		cityInput.sendKeys(city);
		driver.findElement(By.xpath("//div[@class='xp__dates xp__group']")).click();
	}
	
	private void selectDate(String date) {
		String locatorForDate = String.format("//td[@data-date='%s']", date);
		driver.findElement(By.xpath(locatorForDate)).click();
	}
	
	private void guestsVerifyDefaultValues(String adults, String children, String roomsDefault) {
		String adultGuests = driver.findElement(By.xpath("//span[@data-adults-count]")).getText();
		assertEquals(adultGuests, adults);
		String childrenGuests = driver.findElement(By.xpath("//span[@data-children-count]")).getText();
		assertEquals(childrenGuests, children);
		driver.findElement(By.xpath("//label[@id='xp__guests__toggle']")).click();
		String rooms = driver.findElement(By.xpath("//select[@id='no_rooms']")).getAttribute("value");
		assertEquals(rooms, roomsDefault);
	}
	
	private void clickSearchButton() {
		driver.findElement(By.xpath("//button/span[text()='Search']")).click();
	}
	
	private void verifySearchResults() {
		List<WebElement> listOfResults = driver.findElements(By.xpath("//div[@id='hotellist_inner']//a[contains(@class, 'b-button')]"));
		assertTrue(listOfResults.size() > 0, "Error: no hotel found. Should be found at least 1 result.");
	}
	
	private void sortDataByScore() {
		driver.findElement(By.xpath("//a[@data-category='review_score_and_price']")).click();
	}
	
	private void selectTopResult() {
		String locatorForAvailableRooms = "//div[@id='hotellist_inner']/div[1]//a[contains(@class, 'b-button')]";
		WebElement availableRoomsButton = driver.findElement(By.xpath(locatorForAvailableRooms));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.stalenessOf(availableRoomsButton));
		availableRoomsButton = driver.findElement(By.xpath(locatorForAvailableRooms));
		availableRoomsButton.click();
	}
	
	private void retingBiggerThen(int rating) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		String score = driver.findElement(
				By.xpath("//div[@id='js--hp-gallery-scorecard']//div[@class='bui-review-score__badge']")).getText();
		assertTrue(Float.parseFloat(score) >= rating, String.format("Error: score is %s", score));
	}
	
	private void closeAditionalTabs() {
	    String originalHandle = driver.getWindowHandle();
	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }
	    driver.switchTo().window(originalHandle);
	}
	
	private static String getFutureDate(int delta) {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).plusDays(delta).toString();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
