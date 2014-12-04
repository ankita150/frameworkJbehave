package com.framework.project.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshots {
	static WebDriver driver;
	public static void screenShot(String fileName,String filepath) throws IOException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		String modifyDate= formatter.format(date);
		System.out.println(filepath);
		String ScreenshotFileName = filepath+fileName+modifyDate;
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(System.getProperty("src//test//resources//Screenshots")));

	}
}

