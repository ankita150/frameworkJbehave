package com.framework.project.classes;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.project.util.Logs;

public class BaseClass {

	public WebDriver driver;
	@BeforeStories
	public void setUp() {
		Logs.log4j("gmail",(System.getProperty("user.dir")+"//src//test//resources//Logs//"));
		driver= new FirefoxDriver();
		}
	
	@AfterStories
	public void closeAndStop(){
		driver.quit();
	}
}

