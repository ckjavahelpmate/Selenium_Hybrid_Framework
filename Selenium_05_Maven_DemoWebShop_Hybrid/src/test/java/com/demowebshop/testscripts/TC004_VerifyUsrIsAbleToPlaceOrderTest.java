package com.demowebshop.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demowebshop.elementrepository.CheckoutPage;
import com.demowebshop.elementrepository.ComputersPage;
import com.demowebshop.elementrepository.DesktopsPage;
import com.demowebshop.elementrepository.HomePage;
import com.demowebshop.elementrepository.ShoppingCartPage;
import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

@Listeners(com.demowebshop.genericlibrary.ListenerImplementation.class)
public class TC004_VerifyUsrIsAbleToPlaceOrderTest extends BaseTest{
	@Test
	public void addProductToWishList() throws InterruptedException 
	{
//		1.Launch the Browser ==> @BeforeClass
//		2.login ==> @BeforeMethod
//		3.click on Computers link
		HomePage homePage = new HomePage(driver) ;
		homePage.getComputers().click();
		
//		4.Verify Digital Downloads Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.COMPUTERS_PAGE, "Computers Page Is not Displayed");
		Reporter.log("Computers Page Is Displayed", true);
		extentTest.log(Status.INFO, "Computers Page Is Displayed");
		
//		5.Click on Desktop button
		ComputersPage computersPage = new ComputersPage(driver);
		computersPage.getDesktop().click();
		
//		6.Verify Desktop Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.DESKTOPS_PAGE, "Desktop Page Is not Displayed");
		Reporter.log("Desktop Page Is Displayed", true);
		extentTest.log(Status.INFO, "Desktop Page Is Displayed");
		
//		7.Add Products to cart
		DesktopsPage desktopsPage = new DesktopsPage(driver);
		desktopsPage.getSimpleComputer().click();
		desktopsPage.getProcessor().click();
		desktopsPage.getAddToCart().click();
		
//		8.Click on Shopping Cart
		homePage.getShoppingCart().click();
		
//		9.Verify Shopping Cart Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.SHOPPING_CART_PAGE, "Shopping Cart Page Is not Displayed");
		Reporter.log("Shopping Cart Page Is Displayed", true);
		extentTest.log(Status.INFO, "Shopping Cart Page Is Displayed");
		
//		10.Verify added Product is displayed in shopping cart 
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver) ;
		Assert.assertTrue(shoppingCartPage.getSimpleComputer().isDisplayed(), "Added Product is not displayed");
		Reporter.log("Added Product is displayed" , true);
		extentTest.log(Status.INFO, "Added Product is displayed");
		
//		11.Click on terms of services button
		shoppingCartPage.getTermsOfService().click();
		
//		12.click on checkout button
		shoppingCartPage.getCheckout().click();
		
//		13.Verify Checkout Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.CHECKOUT_PAGE, "Checkout Page Is not Displayed");
		Reporter.log("Checkout Page Is Displayed", true);
		extentTest.log(Status.INFO, "Checkout Page Is Displayed");
		
//		14.Select country
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		WebElement dropDown = checkoutPage.getDropDown();
		commonUtility.selectOptionByVisibleText(dropDown, "India");
		
//		15.Enter valid Address details
		checkoutPage.getCity().sendKeys("Bangalore");
		checkoutPage.getAddress().sendKeys("Bangalore");
		checkoutPage.getZipcode().sendKeys("560085");
		checkoutPage.getPhoneNumber().sendKeys("8877556644");
		
//		12.logout
//		13.close the Browser
	
	}

}
