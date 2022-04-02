package test;

import base.BaseTest;
import static org.junit.Assert.*;

import org.apache.hc.core5.util.ByteArrayBuffer;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.LoginPage;
import page.SuccessfulLoginPage;
import org.openqa.selenium.support.Color;

public class SuccessfulLoginTest extends BaseTest {

    LoginPage loginPage;
    SuccessfulLoginPage successfulLoginPage;

    String testUserName = "tomsmith";
    String testPassword = "SuperSecretPassword!";
    String uspesnaRegistracijaMessage = "You logged into a secure area!\n" +
            "×";
    String secureAreaMessage = "Secure Area";
    String welcomeMessage = "Welcome to the Secure Area. When you are done click logout below.";
    String logoutMessage = "You logged out of the secure area!\n" +
            "×";
    String invalidUsernameMessage = "Your username is invalid!\n" + "×";
    String invalidPasswordMessage = "Your password is invalid!\n" + "×";




    @Before
    public void setUpTest() {
        loginPage = new LoginPage();
        successfulLoginPage = new SuccessfulLoginPage();
    }

    @Test
    public void successfulLoginUsingValidInputDataInAllFields() {
        loginPage
                .userNameInputFieldSendKeys(testUserName)
                .passwordInputFieldSendKeys(testPassword)
                .loginButtonClick();
        assertTrue(successfulLoginPage.successfulLoginMessageDisplayed());
        assertEquals(uspesnaRegistracijaMessage, successfulLoginPage.successfulLoginMessageGetText());
        successfulLoginPage.closeMessageClick();

        assertTrue(successfulLoginPage.secureAreaTextDisplayed());
        assertEquals(secureAreaMessage, successfulLoginPage.secureAreaTextGetText());

        assertTrue(successfulLoginPage.welcomeMessageDisplayed());
        assertEquals(welcomeMessage, successfulLoginPage.welcomeMessageGetText());
        successfulLoginPage.logoutButtonClick();
        assertTrue(loginPage.flashingMessageDisplayed());
        assertEquals(logoutMessage, loginPage.flashingMessageGetText());
        loginPage.closeMessageClick();
    }

    @Test
    public void loginUsingInvalidInputDataInUsernameField() {
        loginPage
                .userNameInputFieldSendKeys("t")
                .passwordInputFieldSendKeys(testPassword)
                .loginButtonClick();
        assertTrue(loginPage.flashingMessageDisplayed());
        assertEquals(invalidUsernameMessage, loginPage.flashingMessageGetText());
        Color invalidInputBackgroundColour = Color.fromString(driver.findElement(By.id("flash")).getCssValue("background-color"));
        assert invalidInputBackgroundColour.asHex().equals("#c60f13");

    }

    @Test
    public void loginUsingInvalidInputDataInPasswordField() {
        loginPage
                .userNameInputFieldSendKeys(testUserName)
                .passwordInputFieldSendKeys("S")
                .loginButtonClick();
        assertTrue(loginPage.flashingMessageDisplayed());
        assertEquals(invalidPasswordMessage, loginPage.flashingMessageGetText());
        Color invalidInputBackgroundColour = Color.fromString(driver.findElement(By.id("flash")).getCssValue("background-color"));
        assert invalidInputBackgroundColour.asHex().equals("#c60f13");

    }
    @Test
    public void loginUsingInvalidInputDataInAllFields() {
        loginPage
                .userNameInputFieldSendKeys("1")
                .passwordInputFieldSendKeys("22")
                .loginButtonClick();
        assertTrue(loginPage.flashingMessageDisplayed());
        assertEquals(invalidUsernameMessage, loginPage.flashingMessageGetText());
        //ovde bi trebalo da prikaze poruku "Username and Password are invalid"
        Color invalidInputBackgroundColour = Color.fromString(driver.findElement(By.id("flash")).getCssValue("background-color"));
        assert invalidInputBackgroundColour.asHex().equals("#c60f13");

    }

    @Test
    public void loginLeavingAllFieldsEmpty() {
        loginPage.loginButtonClick();
        assertTrue(loginPage.flashingMessageDisplayed());
        assertEquals("Your username is invalid!\n" + "×", loginPage.flashingMessageGetText());
        //ovde bi trebalo da prikaze poruku "Username and Password can't be empty"
    }
    /*@Test
    public void backgroundColorTest() {
        loginPage
                .userNameInputFieldSendKeys("1")
                .passwordInputFieldSendKeys("22")
                .loginButtonClick();
        Color invalidUsernameBackgroundColour = Color.fromString(driver.findElement(By.id("flash")).getCssValue("background-color"));
        assert invalidUsernameBackgroundColour.asHex().equals("#c60f13");
    }
     */


}
