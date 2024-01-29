package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerImplementation extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String path = FilePaths.SCREENSHOTS_PATH + result.getName() + ".png" ;
		TakesScreenshot ts = ( TakesScreenshot)BaseTest.listenerDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(path);
		try {
			FileHandler.copy(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.log(Status.FAIL,result.getName() + " is failed" );
		extentTest.addScreenCaptureFromPath("."+path, result.getName());
	}
	
	
}
