package com.aiite.excelRead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	
	public static WebDriver driver;
	@BeforeSuite
	public void browserSetUp() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	@Test(dataProvider="getDataExcel",dataProviderClass=ExcelRead.class)
	public void testCase(String data[]) {
		driver.get("https://www.facebook.com/");
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

}
