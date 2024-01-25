package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy( id = "BillingNewAddress_FirstName")
	private WebElement fistName;
	
	@FindBy( id = "BillingNewAddress_LastName")
	private WebElement lastName ;
	
	@FindBy( id = "BillingNewAddress_Email")
	private WebElement email ;
	
	@FindBy( id = "BillingNewAddress_CountryId")
	private WebElement dropDown ;
	
	@FindBy( id = "BillingNewAddress_City")
	private WebElement city ;
	
	@FindBy( id = "BillingNewAddress_Address1")
	private WebElement address ;
	
	@FindBy( id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipcode ;
	
	@FindBy( id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNumber ;
	
	@FindBy( xpath = "//div[@id = 'billing-buttons-container']//input[ @class = 'button-1 new-address-next-step-button']")
	private WebElement contiueButton ;
	
	@FindBy( xpath = "//div[ @class = 'title']")
	private WebElement result ;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFistName() {
		return fistName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getContiueButton() {
		return contiueButton;
	}

	public WebElement getResult() {
		return result;
	}
	

}
