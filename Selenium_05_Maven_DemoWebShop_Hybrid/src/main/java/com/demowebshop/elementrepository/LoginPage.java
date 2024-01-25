package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy( id = "Email")
	private WebElement email ;
	
	@FindBy( id = "Password")
	private WebElement password ;
	
	@FindBy( css ="[class = 'button-1 login-button']")
	private WebElement loginButtion ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButtion() {
		return loginButtion;
	}

}
