package com.amazon.selenium.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    public BasePage(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;
        this.wait = new WebDriverWait(driver, 30);
    }
}
