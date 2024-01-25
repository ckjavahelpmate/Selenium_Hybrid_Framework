package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputersPage {
	
	@FindBy( xpath = "//a[ @href = '/desktops']")
	private WebElement desktop ;
	
	public ComputersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDesktop() {
		return desktop;
	}

}
