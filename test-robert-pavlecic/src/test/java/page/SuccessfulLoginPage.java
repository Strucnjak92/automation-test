package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulLoginPage extends BaseTest {
    public SuccessfulLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "flash")
    WebElement successfulLoginMessage;

    @FindBy(xpath = "//h2[contains(.,'Secure Area')]")
    WebElement secureAreaText;

    @FindBy(className = "subheader")
    WebElement welcomeMessage;

    @FindBy(css = ".button")
    WebElement logoutButton;

    @FindBy(className = "close")
    WebElement closeMessage;


    public boolean successfulLoginMessageDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulLoginMessage));
        return successfulLoginMessage.isDisplayed();
    }
    public String successfulLoginMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(successfulLoginMessage));
        return successfulLoginMessage.getText();
    }

    public boolean secureAreaTextDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(secureAreaText));
        return secureAreaText.isDisplayed();
    }
    public String secureAreaTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(secureAreaText));
        return secureAreaText.getText();
    }

    public boolean welcomeMessageDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.isDisplayed();
    }
    public String welcomeMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.getText();
    }
    public SuccessfulLoginPage logoutButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        return this;
    }

    public SuccessfulLoginPage closeMessageClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(closeMessage));
        closeMessage.click();
        return this;
    }

}

