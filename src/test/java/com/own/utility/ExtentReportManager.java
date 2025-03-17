package com.own.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	
	public ExtentSparkReporter sparkReporter;//UI of the report,It's a class, Look and feel about report.
	public ExtentReports extent;//populate common info on the report
	public ExtentTest test;// creating test case entries in the report and update status of the test methods
	
	
	
	
	public void onStart​(ITestContext result)
	{
		System.out.println("This method will execute before executing of test method");
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/Reporting.html");//
		sparkReporter.config().setDocumentTitle("Automation Report");//Title of report
		sparkReporter.config().setReportName("Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Veera");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome");
		
		
		
		
	}
	
	public void onTestStart​(ITestResult result)
	{
		System.out.println("This method execute before executing of every test method");
		
	}
	
	public void onTestSuccess​(ITestResult result)
	{
		System.out.println("Test method Pass");
		test=extent.createTest(result.getName());//create a new entry in the report
		test.log(Status.PASS, "Test Case PASSED is:" + result.getName()); //Update the status in the report
		
		
	}
	public void onTestFailure​(ITestResult result)
	{
		System.out.println("Test method Failure");
		test=extent.createTest(result.getName());//create a new entry in the report
		test.log(Status.FAIL, "Test Case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is:" + result.getThrowable());
		
		System.out.println("Test method Failure");
		
	}
	public void onTestSkipped​(ITestResult result)
	{
		System.out.println("Test method Skipped");
		test=extent.createTest(result.getName());//create a new entry in the report
		test.log(Status.SKIP, "Test Case SKKIPED is:" + result.getName());
		
		
	}
	public void onFinish​(ITestContext result)
	{
		System.out.println("This method execute after executing of all test methods");
		extent.flush();
	}
}
