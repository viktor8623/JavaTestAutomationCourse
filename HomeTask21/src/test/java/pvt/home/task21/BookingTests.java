package pvt.home.task21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class BookingTests {
    private WebDriver driver;
    private SearchPage searchPage;
    private static final String URL = "https://www.booking.com/";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage = new SearchPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL);
    }

    @Test
    public void testAvailableHotels() {
        searchPage.findDeals("Moscow", 1);
        int numberOfResults = searchPage.getNumberOfResults();
        assertTrue(numberOfResults > 0, "Error: no hotel found. Should be found at least 1 result.");
    }

    @Test
    public void testRatingOfTheFirstSearchResult() {
        searchPage.findDeals("Moscow", 1);
        searchPage.sortDataByScore();
        searchPage.selectTopResult();
        double ratingOfFirstResult = searchPage.getRating();
        int minimalRating = 9;
        assertTrue(ratingOfFirstResult >= minimalRating, String.format("Error: score is %s", ratingOfFirstResult));
        searchPage.closeAdditionalTabs();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
