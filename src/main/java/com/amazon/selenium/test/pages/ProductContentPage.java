package com.amazon.selenium.test.pages;

import com.amazon.selenium.test.locators.ProductContentPageLocators;
import com.amazon.selenium.test.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class ProductContentPage extends BasePage{


    public ProductContentPage(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public String findProductTitle() {
        WebElement productTitleElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
        Assert.assertNotNull(productTitleElement);
        return productTitleElement.getText().trim();
    }

    public void addProductToList(String listName) {
        driver.findElement(ProductContentPageLocators.ADD_TO_LIST_DROPDOWN).click();
        PageUtils.sleep(2000);
        List<WebElement> dropdownItems = driver.findElements(By.xpath("//li[@class='a-dropdown-item']"));
        WebElement dropdownItem = PageUtils.findByContainsText(dropdownItems, listName);
        WebElement addToWishListLink = dropdownItem.findElement(By.xpath(".//a"));
        addToWishListLink.click();
        PageUtils.sleep(2000);
        driver.findElement(ProductContentPageLocators.ADD_TO_WISH_LIST_MENU_CLOSE_BUTTON).click();
    }
}
