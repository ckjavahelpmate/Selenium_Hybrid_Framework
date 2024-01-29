package com.demowebshop.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demowebshop.elementrepository.DigitalDownloadsPage;
import com.demowebshop.elementrepository.HomePage;
import com.demowebshop.elementrepository.ShoppingCartPage;
import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

@Listeners(com.demowebshop.genericlibrary.ListenerImplementation.class)
public class TC003_VerifyUsrIsAbleToAddProductsToCartAndRemoveTest extends BaseTest{
	@Test
	public void addProductToWishList() throws InterruptedException 
	{
//		1.Launch the Browser ==> @BeforeClass
//		2.login ==> @BeforeMethod
//		3.click on Digital Downloads link
		HomePage homePage = new HomePage(driver) ;
		homePage.getDigitalDownloads().click();
		
//		4.Verify Digital Downloads Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.DIGITAL_DOWNLOADS_PAGE, "Digital Downloads Page Is not Displayed");
		Reporter.log("Digital Downloads Page Is Displayed", true);
		extentTest.log(Status.INFO, "Digital Downloads Page Is Displayed");
		
//		5.Add all Products to cart
		DigitalDownloadsPage digitalDownloadsPage = new DigitalDownloadsPage(driver);
		List<WebElement> addToCart = digitalDownloadsPage.getAddToCart() ;
		int numberOfProducts = addToCart.size() ;
		for (WebElement webElement : addToCart) {
			webElement.click(); 
			Thread.sleep(1000);
		}
		
//		6.Click on Shopping Cart Link
		homePage.getShoppingCart().click();
		
//		7.Verify Shopping Cart Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.SHOPPING_CART_PAGE, "Shopping Cart Page Is not Displayed");
		Reporter.log("Shopping Cart Page Is Displayed", true);
		extentTest.log(Status.INFO, "Shopping Cart Page Is Displayed");
		
//		8.Verify ALl the added Product are displayed in Shopping Cart
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		List<WebElement> productNames = shoppingCartPage.getProductName() ;
		Assert.assertEquals( numberOfProducts , productNames.size() , "All Added Products are not displayed");
		Reporter.log("All Added Products are displayed", true );
		extentTest.log(Status.INFO, "All Added Products are displayed");
		
//		9.Click on remove check boxes of all added Products
		List<WebElement> remove = shoppingCartPage.getRemove();
		for (WebElement webElement : remove) {
			webElement.click(); 
		}
		
//		10.Click on Update Shopping Cart button'
		shoppingCartPage.getUpdateCart().click();
		
//		11.Verify all added Products are removed or shopping cart empty is displayed
		Assert.assertTrue(shoppingCartPage.getResult().isDisplayed() , "All Added Products are not removed from Cart");
		Reporter.log("All Added Products are removed from Cart", true );
		extentTest.log(Status.INFO, "All Added Products are removed from Cart");

//		12.logout
//		13.close the Browser
	
	}

}
