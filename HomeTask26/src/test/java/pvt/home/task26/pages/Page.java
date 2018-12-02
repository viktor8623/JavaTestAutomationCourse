package pvt.home.task26.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Page {

	protected WebDriver driver;
	protected Wait<WebDriver> fluentWait;

	public Page(WebDriver driver) {
		this.driver = driver;
		fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
	}
}
