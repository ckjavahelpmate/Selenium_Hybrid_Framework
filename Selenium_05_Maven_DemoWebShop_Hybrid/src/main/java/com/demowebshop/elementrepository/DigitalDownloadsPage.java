package com.demowebshop.elementrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage {
	
	@FindBy( xpath = "//input[ @class ='button-2 product-box-add-to-cart-button']" )
	private List<WebElement> addToCart ;
	
	public DigitalDownloadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAddToCart() {
		return addToCart;
	}
	
}
