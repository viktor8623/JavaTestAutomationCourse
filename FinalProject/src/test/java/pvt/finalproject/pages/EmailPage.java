package pvt.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EmailPage extends Page {

    @FindBy(xpath = "//div[@id='b-nav_folders']//a[@href='/messages/inbox/']")
    public WebElement goToInboxLink;

    @FindBy(xpath = "//div[@id='b-nav_folders']//span[@class='b-nav__item__count']")
    public WebElement unreadEmailsCounter;

    @FindBy(xpath = "//a[@href='/messages/sent/']")
    public WebElement goToSentLink;

    @FindBy(xpath = "//a[@href='/messages/spam/']/span[2]")
    public WebElement goToSpamLink;

    @FindBy(xpath = "//a[@href='/messages/trash/']/span[text()='Корзина']")
    public WebElement goToTrashLink;

    @FindBy(xpath = "//a[@href='/messages/trash/']//span[text()='очистить']")
    public WebElement clearTrashFolderLink;

    @FindBy(xpath = "//button[contains(@class, 'js-clearButton')]")
    public WebElement clearButtonInBalloon;

    @FindBy(xpath = "//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])]")
    public List<WebElement> messages;

    @FindBy(xpath = "//div[@class='b-datalist__empty' and not(ancestor::div[contains(@style, 'display: none;')])]")
    public WebElement emptyBlockInMainWindow;

    @FindBy(xpath = "//div[@data-name='toggle' and not(ancestor::div[contains(@style, 'display: none;')]) " +
            "and not(ancestor::div[contains(@style, 'visibility: hidden;')])]")
    public WebElement checkAll;

    @FindBy(xpath = "(//div[contains(@class, 'checkbox__box') and  not(ancestor::div[contains(@style, 'display: " +
            "none;')]) and ancestor::div[@id='b-letters']])[1]")
    public WebElement firstCheckbox;

    @FindBy(xpath = "(//div[@data-name='spam'])[1]")
    public WebElement spamButton;

    @FindBy(xpath = "//div[@data-group='moveTo' and not(ancestor::div[contains(@style, 'display: none;')]) " +
            "and not(ancestor::div[contains(@style, 'visibility: hidden;')])]")
    public WebElement moveToButton;

    @FindBy(xpath = "//a[@data-text='Входящие' and not(ancestor::div[contains(@style, 'display: none;')])]")
    public WebElement moveToInbox;


    @FindBy(xpath = "//div[@data-name='remove' and not(ancestor::div[contains(@style, 'display: none;')]) " +
            "and not(ancestor::div[contains(@style, 'visibility: hidden;')])]")
    public WebElement removeButton;

    @FindBy(xpath = "(//div[@data-name='noSpam'])[1]")
    public WebElement notSpamButton;

    @FindBy(xpath = "//div[@class='js-ok notify-message' and not(ancestor::div[contains(@style, 'display: none;')])]")
    public List<WebElement> notifications;

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

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    public WebElement logoutLink;

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCheckbox(WebElement message) {
        return message.findElement(By.xpath(".//div[@class='b-checkbox__box']"));
    }

    public WebElement getStatusMark(WebElement message) {
        return message.findElement(By.xpath(".//div[contains(@class, 'b-letterstatus__icon')]"));
    }

    public WebElement getSubject(WebElement message) {
        return message.findElement(By.xpath(".//div[contains(@class, 'subj')]"));
    }

    public WebElement getFlag(WebElement message) {
        return message.findElement(By.xpath(".//div[contains(@class, 'b-flag')]"));
    }

    public boolean isFlagged(WebElement flag) {
        String classes = flag.getAttribute("class");
        return classes.contains("b-flag_yes");
    }

    public boolean isRead(WebElement message) {
        String classes = getStatusMark(message).getAttribute("class");
        return classes.contains("ico_letterstatus_read");
    }

    public void smartClick(WebElement element) {
        waitForClick.until(driver -> {
            element.click();
            return true;
        });
    }

    public void waitForNotification(String expectedText) {
        fluentWait.until(driver -> notifications.get(0).getText().contains(expectedText));
    }

    public void waitForMessagesDisplayed() {
        fluentWait.until(driver -> getSubject(messages.get(0)).getText().length() > 0);
    }

    public void waitForElementDisappearance(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForCangeReadStateTo(boolean desiredState, WebElement message) {
        fluentWait.until(driver1 -> isRead(message) == desiredState);
    }

    public void enterMessage(String message) {
        driver.switchTo().frame(messageTextarea);
        driver.findElement(By.xpath("//body")).sendKeys(message);
        driver.switchTo().defaultContent();
    }
}
