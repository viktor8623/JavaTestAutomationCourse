package pvt.finalproject.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

	protected WebDriver driver;
	protected Wait<WebDriver> fluentWait;
	protected WebDriverWait wait;
	protected Wait<WebDriver> waitForClick;

	public Page(WebDriver driver) {
		this.driver = driver;
		fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
		wait = new WebDriverWait(driver, 15);
        waitForClick = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(StaleElementReferenceException.class);
	}
}
