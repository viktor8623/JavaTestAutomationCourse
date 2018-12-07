package pvt.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmailPage extends Page {

    @FindBy(xpath = "//div[@id='PH_authMenu']//i")
    public List<WebElement> currentInboxAddress;

    @FindBy(xpath = "//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])]")
    public List<WebElement> messages;

    @FindBy(xpath = "(//div[contains(@class, 'b-checkbox__box')])[1]")
    public WebElement checkAll;

    @FindBy(xpath = "(//div[contains(@class, 'checkbox__box') and  not(ancestor::div[contains(@style, 'display: " +
            "none;')]) and ancestor::div[@id='b-letters']])[1]")
    public WebElement firstCheckbox;

    @FindBy(xpath = "(//div[@data-name='spam'])[1]")
    public WebElement spamButton;

    @FindBy(xpath = "(//div[@data-name='noSpam'])[1]")
    public WebElement notSpamButton;

    @FindBy(xpath = "//div[@id='b-nav_folders']//span[text()='Спам']")
    public WebElement spamTab;

    @FindBy(xpath = "//div[@id='b-nav_folders']//span[text()='Входящие']")
    public WebElement inboxTab;

    @FindBy(xpath = "//div[@class='js-ok notify-message']")
    public WebElement notification;

    @FindBy(xpath = "(//a[@data-name='compose'])[1]")
    public WebElement writeLetter;

    @FindBy(xpath = "//textarea[@data-original-name='To']")
    public WebElement toInput;

    @FindBy(xpath = "//input[@name='Subject']")
    public WebElement subjectInput;

    @FindBy(xpath = "//iframe")
    public WebElement messageTextarea;

    @FindBy(xpath = "(//div[@data-name='send'])[1]")
    public WebElement sendButton;

    @FindBy(xpath = "//div[@class='message-sent__title']")
    public WebElement notificationAfterSend;

    @FindBy(xpath = "//span[@class='message-sent__info']")
    public WebElement listOfReceivers;

    @FindBy(xpath = "(//div[contains(@class, 'b-dropdown_more')])[1]")
    public WebElement moreButton;

    @FindBy(xpath = "(//a[@data-name='flag_no'])[1]")
    public WebElement removeFlagOption;

    @FindBy(xpath = "//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])]//div[contains" +
            "(@class, 'b-flag_yes')]//b")
    public List<WebElement> flags;

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForNotification() {
        fluentWait.until(driver -> notification.getText().length() > 0);
    }

    public void waitForVisibility(WebElement element) {
        fluentWait.until(driver -> element.isDisplayed());
    }

    public void waitForMessageDisappearance(int numberOfMessages) {
        fluentWait.until(driver -> messages.size() == numberOfMessages - 1);
    }

    public void enterMessage(String message) {
        driver.switchTo().frame(messageTextarea);
        driver.findElement(By.xpath("//body")).sendKeys(message);
        driver.switchTo().defaultContent();
    }

    public void markWithFlag(WebElement messageRow) {
        messageRow.findElement(By.xpath(".//div[@data-act='flag']")).click();
    }
}
