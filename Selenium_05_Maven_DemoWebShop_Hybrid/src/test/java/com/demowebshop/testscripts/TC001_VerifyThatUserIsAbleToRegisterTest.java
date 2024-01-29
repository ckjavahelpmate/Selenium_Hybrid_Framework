package com.demowebshop.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demowebshop.elementrepository.HomePage;
import com.demowebshop.elementrepository.RegisterPage;
import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

@Listeners(com.demowebshop.genericlibrary.ListenerImplementation.class)
public class TC001_VerifyThatUserIsAbleToRegisterTest 
{
	BaseTest baseTest = new BaseTest() ;
	@Test( dataProvider = "register" )
	public void register(String fisrtName, String lastName, String email, String password, String confirmPassword) 
	{
		String modifiedEmail = baseTest.commonUtility.getRandom() + email ;
		
//		1.Launch Browser
		baseTest.launchBrowser("Chrome");
		WebDriver driver = baseTest.driver ;
//		2.click on register ;
		HomePage homePage = new HomePage(driver) ;
		homePage.getRegisterLink().click();
		
//		3.Verify Register Page is Displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.REGISTER_PAGE,"Register Page Is Not Displayed");
		Reporter.log("Register Page is Displayed", true);
		
//		4.Enter Valid Credentials and click on Register Button
		RegisterPage registerPage = new RegisterPage(driver) ;
		registerPage.getMaleRadioButton().click();
		registerPage.getFirstName().sendKeys(fisrtName);
		registerPage.getLastName().sendKeys(lastName);
		registerPage.getEmail().sendKeys(modifiedEmail);
		registerPage.getPassword().sendKeys(password);
		registerPage.getConfirmPassword().sendKeys(confirmPassword);
		registerPage.getRegisterButton().click();
		registerPage.getContinueButton().click();
		
//		5.Verify user is Registered or not
		String actualEmail = homePage.getLogedEmail().getText() ;
		Assert.assertEquals(actualEmail, modifiedEmail , "User is not Registered");
		Reporter.log("User Registeredm successfully", true );
		
		
//		6.Logout
//		baseTest.logout();
		homePage.getLogoutLink().click();
		
//		7.close the browser
		baseTest.closeBrowser();
		
	}
	
	@DataProvider(name = "register")
	public Object[][] dataProvider() 
	{
		return baseTest.dataUtility.getAllDataFromExcel("DemoWebShop") ;
	}
}
