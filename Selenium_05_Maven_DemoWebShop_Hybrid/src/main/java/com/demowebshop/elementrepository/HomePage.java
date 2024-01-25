package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy( css = "[class = 'ico-register']")
	private WebElement registerLink ;
	
	@FindBy( css = "[class = 'ico-login']")
	private WebElement loginLink ;
	
	@FindBy( css = "[class = 'ico-logout']")
	private WebElement logoutLink ;
	
	@FindBy( linkText = "Shopping cart")
	private WebElement shoppingCart;
	
	@FindBy( linkText = "Wishlist")
	private WebElement wishList;
	
	@FindBy( xpath = "//a[ contains(text() ,'Books')]")
	private WebElement bookLink;
	
	@FindBy( linkText = "Computers")
	private WebElement computers;
	
	@FindBy( xpath = "//a[ @href = '/digital-downloads']")
	private WebElement digitalDownloads ;
	
	@FindBy(xpath = "//a[ @class = 'account']")
	private WebElement logedEmail;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public WebElement getWishList() {
		return wishList;
	}

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getComputers() {
		return computers;
	}

	public WebElement getDigitalDownloads() {
		return digitalDownloads;
	}
	
	public WebElement getLogedEmail() {
		return logedEmail;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	
}
