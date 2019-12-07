package com.amazon.selenium.test.pages;

import com.amazon.selenium.test.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class ListPage extends BasePage {

    public ListPage(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void validateExistsProduct(String productTitle) {
        List<WebElement> productsElements = driver.findElements(By.xpath("//div[@id='wl-item-view']//li"));
        WebElement productElement = PageUtils.findByContainsText(productsElements, productTitle);
        Assert.assertNotNull(productElement);
    }

    public void deleteWishListProduct(String productTitle) {
        List<WebElement> wishListProductElements = driver.findElements(By.xpath("//div[@id='wl-item-view']//li"));
        WebElement wishListProductElement = PageUtils.findByContainsText(wishListProductElements, productTitle);
        WebElement deleteWishListProductButton = wishListProductElement.findElement(By.xpath("//span[@id='a-autoid-7']//input[@name='submit.deleteItem']"));
        deleteWishListProductButton.click();
    }

    public void validateNotExistsProduct(String productTitle) {
        List<WebElement> wishListProducts = driver.findElements(By.xpath("//div[@id='wl-item-view']//li"));
        WebElement wishListProduct = PageUtils.findByContainsText(wishListProducts, productTitle);
        WebElement deletedNotificationEvent = wishListProduct.findElement(By.xpath("//div[contains(text(),'Deleted')]"));
        Assert.assertNotNull(deletedNotificationEvent);
    }

}
