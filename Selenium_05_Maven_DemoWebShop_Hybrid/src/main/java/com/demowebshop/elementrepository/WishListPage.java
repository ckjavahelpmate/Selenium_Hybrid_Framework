package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	@FindBy( xpath = "//a[ text() = 'Fiction EX']" )
	private WebElement fictionEX ;
	
	@FindBy( name = "removefromcart" )
	private WebElement removeFromWishList ;
	
	@FindBy( name = "updatecart" )
	private WebElement updateWishlist ;
	
	@FindBy( className = "wishlist-content" )
	private WebElement result ;
	
	public WishListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFictionEX() {
		return fictionEX;
	}

	public WebElement getRemoveFromWishList() {
		return removeFromWishList;
	}

	public WebElement getUpdateWishlist() {
		return updateWishlist;
	}

	public WebElement getResult() {
		return result;
	}
	
}
