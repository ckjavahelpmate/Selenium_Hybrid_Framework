package com.demowebshop.elementrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy( xpath =  "//a[ @class = 'product-name']" )
	private List<WebElement> productName ;
	
	@FindBy( name = "removefromcart" )
	private List<WebElement> remove ;
	
	@FindBy( name = "updatecart" )
	private WebElement updateCart ;
	
	@FindBy( className = "order-summary-content" )
	private WebElement result ;
	
	@FindBy( id = "termsofservice" )
	private WebElement termsOfService ;
	
	@FindBy( id = "checkout" )
	private WebElement checkout ;
	
	@FindBy( xpath = "//a[ text() = 'Simple Computer' and @class = 'product-name']")
	private WebElement simpleComputer ;
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProductName() {
		return productName;
	}

	public List<WebElement> getRemove() {
		return remove;
	}

	public WebElement getUpdateCart() {
		return updateCart;
	}

	public WebElement getResult() {
		return result;
	}

	public WebElement getTermsOfService() {
		return termsOfService;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getSimpleComputer() {
		return simpleComputer;
	}
	
}
