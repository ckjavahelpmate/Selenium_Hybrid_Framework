package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	public String takeScreenShot(WebDriver driver) {
		String path = FilePaths.SCREENSHOTS_PATH + getDateAndTime() + ".png" ;
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File(path));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
		return "."+path ;
	}
	
	public String getDateAndTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}

	public int getRandom() {
		return new Random().nextInt(1000);
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTestFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void enterTestINtoAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void selectOptionByIndex(WebElement webElement, int index) {
		new Select(webElement).selectByIndex(index);
	}

	public void selectOptionByValue(WebElement webElement, String value) {
		new Select(webElement).selectByValue(value);
	}

	public void selectOptionByVisibleText(WebElement webElement, String visibleText) {
		new Select(webElement).selectByVisibleText(visibleText);
	}

	public void deselectOptionByIndex(WebElement webElement, int index) {
		new Select(webElement).deselectByIndex(index);
	}

	public void deselectOptionByValue(WebElement webElement, String value) {
		new Select(webElement).deselectByValue(value);
	}

	public void deselectOptionByVisibleText(WebElement webElement, String visibleText) {
		new Select(webElement).deselectByVisibleText(visibleText);
	}

	public void deselectAllOptions(WebElement webElement) {
		new Select(webElement).deselectAll();
	}

	public List<WebElement> getAllOptions(WebElement webElement) {
		return new Select(webElement).getOptions();
	}

	public boolean isMulltiple(WebElement element) {
		return new Select(element).isMultiple();
	}
}
