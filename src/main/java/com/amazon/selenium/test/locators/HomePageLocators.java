package com.amazon.selenium.test.locators;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By LOGO = By.xpath("//span[@class='nav-sprite nav-logo-base']");

    public static final By SIGN_IN_BUTTON = By.xpath("//span[contains(@class,'nav-line-2')][contains(text(),'Account & Lists')]");

    public static final By SEARCH_TEXT = By.xpath("//input[@id='twotabsearchtextbox']");

    public static final By SEARCH_BUTTON = By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");

}
