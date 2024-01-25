package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FictionExPage {
	
	@FindBy( id = "add-to-wishlist-button-78" )
	private WebElement addToWishlist ;
	
	public FictionExPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToWishlist() {
		return addToWishlist;
	}
	
}
