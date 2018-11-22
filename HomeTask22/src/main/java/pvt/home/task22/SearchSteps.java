package pvt.home.task22;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class SearchSteps {
    private static final String MAIN_URL = "http://booking.com";
    private SearchPage searchPage;
    private WebDriver driver;

    public SearchSteps() {
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        driver.get(MAIN_URL);
    }

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\" and run the search$")
    public void findDeals(String city, int daysFromToday) {
        searchPage.findDeals(city, daysFromToday);
    }

    @When("^I am clicking Top Reviewed option on the result page$")
    public void clickTopReviewed() {
        searchPage.sortDataByScore();
    }

    @When("^I open the first offer$")
    public void openFirstOffer() {
        searchPage.selectTopResult();
    }

    @Then("^I see at least one result of the search$")
    public void verifyThatResultsAreFound() {
        int numberOfResults = searchPage.getNumberOfResults();
        assertTrue("Error: no hotel found. Should be found at least 1 result.", numberOfResults > 0);
    }

    @Then("^I see that rating of the hotel >= 9$")
    public void ratingMoreThanNine() {
        double ratingOfFirstResult = searchPage.getRating();
        int minimalRating = 9;
        assertTrue(String.format("Error: score is %s", ratingOfFirstResult),
                ratingOfFirstResult >= minimalRating);
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
