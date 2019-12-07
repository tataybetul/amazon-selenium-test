package com.amazon.selenium.test.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By EMAIL_TEXT = By.xpath("//input[@id='ap_email']");

    public static final By CONTINUE_BUTTON = By.xpath("//input[@id='continue']");

    public static final By PASSWORD_TEXT = By.xpath("//input[@id='ap_password']");

    public static final By SIGN_IN_BUTTON = By.xpath("//input[@id='signInSubmit']");
}
