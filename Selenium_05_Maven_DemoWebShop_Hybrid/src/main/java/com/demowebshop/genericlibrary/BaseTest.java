package com.demowebshop.genericlibrary;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demowebshop.elementrepository.HomePage;
import com.demowebshop.elementrepository.LoginPage;

public class BaseTest {
	public DataUtility dataUtility = new DataUtility();
	public CommonUtility commonUtility = new CommonUtility();
	public WebDriver driver;
	public static WebDriver listenerDriver;
	HomePage homePage;

	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome") String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter Valid Browser");
		}
		listenerDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(dataUtility.getDataFromProperties("url"));

		Assert.assertEquals(driver.getTitle(), PageTitles.HOME_PAGE, "Home Page is not Displayed");
		Reporter.log("Home Page is Displayed", true);
	}

	@BeforeMethod(alwaysRun = true)
	public void login() {
		String email = dataUtility.getDataFromProperties("email");
		String password = dataUtility.getDataFromProperties("password");

		homePage = new HomePage(driver);

		homePage.getLoginLink().click();

		Assert.assertEquals(driver.getTitle(), PageTitles.LOGIN_PAGE, "Login Page is not Displayed");
		Reporter.log("Login page is displayed", true);

		new LoginPage(driver).getEmail().sendKeys(email, Keys.TAB, password, Keys.TAB, Keys.ENTER);

		String logedEmail = homePage.getLogedEmail().getText();
		Assert.assertEquals( logedEmail , email , "User is not Loged in");
		Reporter.log("User loged In", true);
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		new HomePage(driver).getLogoutLink().click();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
