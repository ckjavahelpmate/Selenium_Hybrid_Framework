package com.demowebshop.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demowebshop.elementrepository.BooksPage;
import com.demowebshop.elementrepository.FictionExPage;
import com.demowebshop.elementrepository.HomePage;
import com.demowebshop.elementrepository.WishListPage;
import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

@Listeners(com.demowebshop.genericlibrary.ListenerImplementation.class)
public class TC002_VerifyUsrIsAbleToAddProductToWishListAndRemoveTest extends BaseTest{
	@Test
	public void addProductToWishList() 
	{
//		1.Launch the Browser ==> @BeforeClass
//		2.login ==> @BeforeMethod
//		3.click on Books link
		HomePage homePage = new HomePage(driver) ;
		homePage.getBookLink().click();
		
//		4.Verify Book Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.BOOKS_PAGE, "Books Page Is not Displayed");
		Reporter.log("Books Page Is Displayed", true);
		extentTest.log(Status.INFO, "Books Page Is Displayed");
		
//		5.Click on Fiction EX Book link
		BooksPage booksPage = new BooksPage(driver) ;
		booksPage.getFictionEX().click();
		
//		6.Click on add to wish List
		FictionExPage fictionExPage = new FictionExPage(driver) ;
		fictionExPage.getAddToWishlist().click();
		
//		7.Click on Wish List Link
		homePage.getWishList().click();
		
//		8.Verify Wish List Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.WISHLIST_PAGE , "Wish List Page is not Displayed");
		Reporter.log("Wish List Page is Displayed" , true );
		extentTest.log(Status.INFO, "Wish List Page is Displayed");
		
//		9.verify added product is displayed in wish list
		WishListPage wishListPage = new WishListPage(driver) ;
		Assert.assertTrue(wishListPage.getFictionEX().isDisplayed() , "Added Product is not displayed in wish List");
		Reporter.log("Added Product is displayed in wish List", true );
		extentTest.log(Status.INFO, "Added Product is displayed in wish List");
		
//		10.Click on remove check box of added Product
		wishListPage.getRemoveFromWishList().click();
		
//		11.Click on update wish List button
		wishListPage.getUpdateWishlist().click();
		
//		12.Verify added Product is removed from wish list
		Assert.assertTrue( wishListPage.getResult().isDisplayed() , "Added Product is not removed");
		Reporter.log("Added Product is removed", true );
		extentTest.log(Status.INFO, "Added Product is removed");
		extentTest.addScreenCaptureFromPath(commonUtility.takeScreenShot(driver), "AddToWishList");
		
//		13.logout
//		14.close the Browser
	
	}

}
