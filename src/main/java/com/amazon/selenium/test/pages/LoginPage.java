package com.amazon.selenium.test.pages;

import com.amazon.selenium.test.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class LoginPage extends BasePage {

    private final String email;
    private final String password;

    public LoginPage(WebDriver driver, Properties properties) {
        super(driver, properties);
        this.email = properties.getProperty("email");
        this.password = properties.getProperty("password");
    }

    public void sendEmail() {
        WebElement emailText = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.EMAIL_TEXT));
        emailText.click();
        emailText.sendKeys(email);
    }

    public void continueButton() {
        WebElement continueButton =wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.CONTINUE_BUTTON));
        continueButton.click();
    }

    public void sendPassword() {
        WebElement passwordText = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.PASSWORD_TEXT));
        passwordText.click();
        passwordText.sendKeys(password);
    }

    public void signInButton() {
        WebElement signInButton =wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.SIGN_IN_BUTTON));
        signInButton.click();
    }
}
