package page;

import base.BaseTest;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userNameInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(css = ".fa")
    WebElement loginButton;
    @FindBy(id = "flash")
    WebElement flashingMessage;
    @FindBy(className = "close")
    WebElement closeMessage;
    //@FindBy(css = ".error")

    public LoginPage userNameInputFieldSendKeys(String username) {
        wdWait.until(ExpectedConditions.visibilityOf(userNameInputField));
        userNameInputField.clear();
        userNameInputField.sendKeys(username);
        return this;
    }
    public LoginPage passwordInputFieldSendKeys(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        return this;
    }
    public LoginPage loginButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;
    }
    public boolean flashingMessageDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(flashingMessage));
        return flashingMessage.isDisplayed();
    }
    public String flashingMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(flashingMessage));
        return flashingMessage.getText();
    }
    public LoginPage closeMessageClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(closeMessage));
        closeMessage.click();
        return this;
    }

}
