package com.amazon.selenium.test.pages;

import com.amazon.selenium.test.locators.HomePageLocators;
import com.amazon.selenium.test.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class HomePage extends BasePage{

    private String url;
    private String title;
    private String search_text;

    public HomePage(WebDriver driver, Properties properties) {
        super(driver, properties);
        this.url = properties.getProperty("homePageUrl");
        this.title = properties.getProperty("homePageTitle");
        this.search_text = properties.getProperty("searchText");
    }

    public void open() {
        driver.get(url);
    }

    public void validatePage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HomePageLocators.LOGO));
        Assert.assertNotNull(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), title);
    }

    public LoginPage redirectLoginPage() {
        driver.findElement(HomePageLocators.SIGN_IN_BUTTON).click();
        return new LoginPage(driver, properties);
    }

    public void searchText() {
        WebElement searchText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.SEARCH_TEXT));
        searchText.click();
        searchText.sendKeys(search_text);
    }

    public ProductResultPage searchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.SEARCH_BUTTON));
        searchButton.click();
        return new ProductResultPage(driver, properties);
    }

    public ListPage redirectListPage(String listName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
        PageUtils.sleep(1000);
        List<WebElement> nawItems = driver.findElements(By.xpath("//div[@id='nav-flyout-wl-items']//a"));
        for (WebElement aTagElement: nawItems) {
            String text = aTagElement.findElement(By.xpath(".//span")).getAttribute("innerText");
            if (text.contains(listName)) {
                action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
                PageUtils.sleep(1000);
                aTagElement.click();
            }
        }
        return new ListPage(driver, properties);
    }
}
