package com.amazon.selenium.test.locators;

import org.openqa.selenium.By;

public class ProductResultPageLocators {

    public static final By SEARCH_RESULT_LIST = By.xpath("//div[@class='s-result-list s-search-results sg-row']");

    public static By getPage(Integer page) {
        String xpath = "//li[@class='a-normal']//a[contains(text(),'%s')]";
        return By.xpath(String.format(xpath, page));
    }

    public static By getProduct(Integer productOrder) {
        String xpath = "//*[@data-cel-widget='search_result_%s']";
        return By.xpath(String.format(xpath, productOrder));
    }

    public static By PRODUCT_CLICK_LINK = By.xpath(".//a[@class='a-link-normal a-text-normal']");
}
