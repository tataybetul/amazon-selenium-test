package com.amazon.selenium.test.pages;

import com.amazon.selenium.test.BasePageTest;
import com.amazon.selenium.test.utils.PageUtils;
import org.testng.annotations.Test;

public class ListPageTest extends BasePageTest {

	@Test
	public void it_should_delete_wish_list_product_item() throws InterruptedException {

		HomePage homePage = new HomePage(driver, properties);
		homePage.open();
		homePage.validatePage();
		Thread.sleep(2000);
		
		LoginPage loginPage = homePage.redirectLoginPage();
		Thread.sleep(2000);

		loginPage.sendEmail();
		loginPage.continueButton();

		Thread.sleep(2000);

		loginPage.sendPassword();
		loginPage.signInButton();
		Thread.sleep(2000);

		homePage.searchText();
		ProductResultPage productResultPage = homePage.searchButton();
		Thread.sleep(2000);


		productResultPage.validateExistsProductResult();
		productResultPage.selectPage(2);
		PageUtils.sleep(2000);

		ProductContentPage productContentPage = productResultPage.clickProduct(3);
		PageUtils.sleep(2000);

		String productTitle = productContentPage.findProductTitle();
		productContentPage.addProductToList("Wish List");
		PageUtils.sleep(2000);


		ListPage listPage = homePage.redirectListPage("Wish List");
		PageUtils.sleep(2000);
		listPage.validateExistsProduct(productTitle);
		listPage.deleteWishListProduct(productTitle);
		PageUtils.sleep(2000);
		listPage.validateNotExistsProduct(productTitle);
	}
}
