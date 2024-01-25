package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage {
	
	@FindBy( xpath = "//a[ text() = 'Simple Computer']")
	private WebElement simpleComputer ;
	
	@FindBy( id = "product_attribute_75_5_31_96")
	private WebElement processor ;
	
	@FindBy( id = "add-to-cart-button-75")
	private WebElement addToCart ;
	
	
	public DesktopsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSimpleComputer() {
		return simpleComputer;
	}

	public WebElement getProcessor() {
		return processor;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}
	
}
