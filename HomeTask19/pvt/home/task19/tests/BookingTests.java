package pvt.home.task19.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pvt.home.task19.model.SearchQuery;

public class BookingTests extends TestBase {
	
	@Test(dataProvider = "query1", dataProviderClass = DataProviders.class)
	public void testCheapHotelsPrices(SearchQuery query) {
		app.goToMainPage(query.getUrl());
		app.selectCity(query.getCity());
		app.selectDate(query.getStartDate(), query.getEndDate());
		app.selectGuestsAndRooms(query.getAdults(), query.getChildren(), query.getRooms());
		app.clickSearchButton();
		app.sortByLowerPrice();
		app.clickTopReviewed();
		List<WebElement> listOfResults = app.getValidSearchResults();
		assertTrue(listOfResults.size() > 0, "Error. Found 0 results");
		app.verifyPriceRange(query.getTripDuration());
	}
	
	@Test(dataProvider = "query2", dataProviderClass = DataProviders.class)
	public void testExpensiveHotelsPrices(SearchQuery query) {
		app.goToMainPage(query.getUrl());
		app.selectCity(query.getCity());
		app.selectDate(query.getStartDate(), query.getEndDate());
		app.selectGuestsAndRooms(query.getAdults(), query.getChildren(), query.getRooms());
		app.clickSearchButton();
		app.sortByHighestPrice();
		app.clickLowestPriceFirst();
		List<WebElement> listOfResults = app.getValidSearchResults();
		assertTrue(listOfResults.size() > 0, "Error. Found 0 results");
		app.verifyPriceRange(query.getTripDuration());
	}
	
	@Test(dataProvider = "order", dataProviderClass = DataProviders.class)
	public void orderWithTestCreditCard(SearchQuery query) {
		app.goToMainPage(query.getUrl());
		app.selectCity(query.getCity());
		app.selectDate(query.getStartDate(), query.getEndDate());
		app.selectGuestsAndRooms(query.getAdults(), query.getChildren(), query.getRooms());
		app.clickSearchButton();
		app.sortByHighestPrice();
		app.clickLowestPriceFirst();
		app.clickFirstOffer();
		app.bookTickets(query);
		app.verifyInvalidCardAlert();
	}	
}
