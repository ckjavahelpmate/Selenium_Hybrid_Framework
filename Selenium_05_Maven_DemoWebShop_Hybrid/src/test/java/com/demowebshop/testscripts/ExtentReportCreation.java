package com.demowebshop.testscripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCreation {
	
	@Test
	public void report() 
	{
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/demo.html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		
		ExtentTest extentTest = extentReports.createTest("TestCase01");
		
		extentTest.log(Status.INFO, "Launching Browser");
		extentTest.log(Status.PASS, "Home page Displayed");
		extentTest.log(Status.PASS, "Login Page displayed");
		
		extentReports.flush();
	}

}
