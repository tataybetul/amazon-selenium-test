package com.amazon.selenium.test.pages;

import com.amazon.selenium.test.locators.ProductResultPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Properties;

public class ProductResultPage extends BasePage {

    public ProductResultPage(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void validateExistsProductResult() {
        WebElement result = driver.findElement(ProductResultPageLocators.SEARCH_RESULT_LIST);
        Assert.assertNotNull(result);
    }

    public void selectPage(Integer page) {
        driver.findElement(ProductResultPageLocators.getPage(page)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("page=%s", page)));
    }

    public ProductContentPage clickProduct(Integer productOrder) {
        driver.findElement(ProductResultPageLocators.getProduct(productOrder-1))
                .findElement(ProductResultPageLocators.PRODUCT_CLICK_LINK)
                .click();
        return new ProductContentPage(driver, properties);
    }
}
