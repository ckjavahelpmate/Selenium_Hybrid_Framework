package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {

	@FindBy( xpath = "//a[ text() = 'Fiction EX']" )
	private WebElement fictionEX ;
	
	public BooksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFictionEX() {
		return fictionEX;
	}
	
}

