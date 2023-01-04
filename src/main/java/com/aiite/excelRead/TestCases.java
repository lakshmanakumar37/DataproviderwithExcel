package com.aiite.excelRead;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	
	public static WebDriver driver;
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;
	
	@BeforeSuite
	public void browserSetUp() {
		reports = new ExtentReports();
		htmlReporter= new ExtentHtmlReporter("target/Reports.html");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Facebook Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);
		reports.attachReporter(htmlReporter);
		
	
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	@Test(dataProvider="getDataExcel",dataProviderClass=ExcelRead.class)
	public void testCase(String data[]) {
		driver.get("https://www.facebook.com/");
		reports.createTest("This is excelTest");
		driver.findElement(By.id("email")).sendKeys(data[0]);
		driver.findElement(By.id("pass")).sendKeys(data[1]);
		/*
		 * driver.get(
		 * "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 * 
		 * driver.findElement(By.
		 * xpath("(//input[@class='oxd-input oxd-input--active'])[1]")).sendKeys(data[0]
		 * ); driver.findElement(By.
		 * xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(data[1]
		 * ); driver.findElement(By.xpath("//button[@type='submit']")).click();
		 */
	}
	@Test
	public void testCase2(ITestResult result) throws IOException {
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		reports.createTest("This is second testCase");
		Assert.assertTrue(false);
		testCase.log(Status.FAIL, "This is failed Case");
		if(result.getStatus()==ITestResult.FAILURE) {
			Screenshot.takeScreenshots();
			testCase.addScreenCaptureFromPath("target\\screenshot.png");
		}
		
	}
	
	@AfterSuite
	public void browserClose() {
		reports.flush();
		driver.quit();
	}

}
