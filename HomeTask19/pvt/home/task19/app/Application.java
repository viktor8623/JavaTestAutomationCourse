package pvt.home.task19.app;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pvt.home.task19.model.SearchQuery;
import pvt.home.task19.pages.MainPage;
import pvt.home.task19.pages.OrderPage;
import pvt.home.task19.pages.ResultPage;
import pvt.home.task19.pages.SearchBar;

public class Application {

	private WebDriver driver;

	private MainPage mainPage;
	private SearchBar searchBar;
	private ResultPage resultPage;
	private OrderPage orderPage;

	public Application() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		mainPage = new MainPage(driver);
		searchBar = new SearchBar(driver);
		resultPage = new ResultPage(driver);
		orderPage = new OrderPage(driver);
	}

	public void quit() {
		driver.quit();
	}

	public void goToMainPage(String url) {
		mainPage.open(url);
	}

	public void selectCity(String city) {
		searchBar.cityInput.clear();
		searchBar.cityInput.sendKeys(city);
	}

	public void selectDate(String startData, String endData) {
		searchBar.datepicker.click();
		searchBar.pickDate(startData);
		searchBar.pickDate(endData);
	}

	public void selectGuestsAndRooms(int adults, int children, int rooms) {
		boolean pageWithSelects = searchBar.roomsSelects.size() > 0 ? true : false;
		searchBar.guestsDropDown.click();
		if (pageWithSelects) {
			setValueBySelects(searchBar.roomsSelect, rooms);
			setValueBySelects(searchBar.adultsSelect, adults);
			setValueBySelects(searchBar.childrenSelect, children);
		} else if (!pageWithSelects) {
			setValueByButtons(searchBar.roomsCount, searchBar.roomsPlusButton, searchBar.roomsMinusButton, rooms);
			setValueByButtons(searchBar.adultsCount, searchBar.adultsPlusButton, searchBar.adultsMinusButton, adults);
			setValueByButtons(searchBar.childrenCount, searchBar.childrenPlusButton, searchBar.childrenMinusButton,
					children);
		} else {
			System.out.println("Enable to figure out if selects are on the page.");
		}
	}

	public void setValueByButtons(WebElement counter, WebElement plusButton, WebElement minusButton, int value) {
		int currentValue = Integer.parseInt(counter.getText());
		int desiredValue = value;
		while (currentValue != desiredValue) {
			if (currentValue > desiredValue) {
				minusButton.click();
			} else {
				plusButton.click();
			}
			currentValue = Integer.parseInt(counter.getText());
		}
	}

	public void setValueBySelects(WebElement select, int value) {
		new Select(select).selectByVisibleText(String.valueOf(value));
	}

	public void clickSearchButton() {
		searchBar.searchButton.click();
	}

	public void sortByLowerPrice() {
		resultPage.filterByPriceFirst.click();
		resultPage.waitForUpdate();
	}

	public void sortByHighestPrice() {
		resultPage.filterByPriceLast.click();
		resultPage.waitForUpdate();
	}

	public List<WebElement> getValidSearchResults() {
		if (resultPage.separators.size() > 0) {
			return resultPage.listOfResultsAboveSeparator;
		} else {
			return resultPage.listOfResults;
		}
	}

	public void clickTopReviewed() {
		if (resultPage.threeDotsButton.size() > 0) {
			resultPage.threeDotsButton.get(0).click();
			resultPage.topReviewed.click();
		} else {
			resultPage.topReviewed.click();
		}
		resultPage.waitForUpdate();
	}

	public void clickLowestPriceFirst() {
		resultPage.lowestPriceFirst.click();
		resultPage.waitForUpdate();
	}

	public void verifyPriceRange(int tripDuration) {
		ArrayList<String> listOfPrices = resultPage.getListOfPrices(resultPage.firstResult);
		ArrayList<Integer> offerPrices = new ArrayList<Integer>();
		for (String price : listOfPrices) {
			offerPrices.add(Integer.parseInt(price.replaceAll(".*BYN", "").replaceAll(",", "").trim()));
		}
		ArrayList<Integer> limits = getLimitsFromSelectedFilter();
		int minLimit = limits.get(0);
		for (Integer price : offerPrices) {
			assertTrue(price >= minLimit * tripDuration,
					String.format("Error! Price is %s but min limit is %s", price, minLimit * tripDuration));
		}
		if (limits.size() > 1) {
			int maxLimit = limits.get(1);
			for (Integer price : offerPrices) {
				assertTrue(price <= maxLimit * tripDuration,
						String.format("Error! Price is %s but min limit is %s", price, maxLimit * tripDuration));
			}
		}
	}

	private ArrayList<Integer> getLimitsFromSelectedFilter() {
		String selectedFilterText = resultPage.selectedFilter.getText();
		selectedFilterText = selectedFilterText.replaceAll(",", "");
		Matcher m = Pattern.compile("\\d+").matcher(selectedFilterText);
		ArrayList<Integer> limits = new ArrayList<Integer>();
		while (m.find()) {
			limits.add(Integer.parseInt(m.group()));
		}
		return limits;
	}

	public void clickFirstOffer() {
		resultPage.clickAvailableRooomsButton(resultPage.firstResult);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}

	public void bookTickets(SearchQuery order) {
		new Select(orderPage.roomsSelect).selectByValue("1");
		orderPage.reserveButton.click();
		orderPage.lastNameInput.sendKeys(order.getLastName());
		orderPage.emailInput.sendKeys(order.getEmail());
		orderPage.confirmEmailInput.sendKeys(order.getEmail());
		orderPage.finalDetailsButton.click();
		if (orderPage.addressInputs.size() > 0) {
			orderPage.addressInput.sendKeys(order.getAddress());
			orderPage.cityInput.sendKeys(order.getHomeCity());
		}
		orderPage.phoneInput.sendKeys(order.getPhone());
		orderPage.payNowCheckbox.click();
		new Select(orderPage.ccTypeSelect).selectByValue(order.getCcType());
		orderPage.ccNumberInput.sendKeys(order.getCcNumber());
		new Select(orderPage.expMonthSelect).selectByValue(order.getExpMonth());
		new Select(orderPage.expYearSelect).selectByValue(order.getExpYear());
		orderPage.cvcCodeInput.sendKeys(order.getCvc());
		orderPage.compliteBookingButton.click();
	}

	public void verifyInvalidCardAlert() {
		WebElement errorAlert = orderPage.waitForAlert();
		assertTrue(errorAlert.isDisplayed(), "There is no alert.");
	}
}
