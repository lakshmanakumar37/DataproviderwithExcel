package com.aiite.excelRead;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends TestCases {
	
	public static void takeScreenshots() throws IOException {
		
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("target\\screenshot.png"));
	}

}
