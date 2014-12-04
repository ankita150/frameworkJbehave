package com.framework.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.framework.project.util.Logs;
import com.framework.project.util.Property;

public class LoginPage {

	private static LoginPage logInPage;
	public  WebDriver driver;
	private static WebElement login_username;
	public static WebElement login_password;
	public static WebElement login_click;
	public static final By TXT_USER_NAME = By.name("Email");
	public static final By TXT_PASSWORD = By.name("Passwd");
	public static final By SIGN_IN_BTN = By.name("signIn");

	public LoginPage (WebDriver driver){
		this.driver = driver;
		System.out.println("In LoginPage Cons");
	}

	//This method will enterusername in gmail login page
	public LoginPage enterUsername(){
		login_username = driver.findElement((TXT_USER_NAME));
		login_username.sendKeys(Property.read("username"));
		Logs.info("username");
		return logInPage;
	}

	//it will enter password in gmail login page
	public LoginPage enterPassword(){
		login_password = driver.findElement((TXT_PASSWORD));
		login_password.sendKeys(Property.read("password"));
		return logInPage;
	}

	//It will click on gmail signin button
	public HomePage loginBtn(){
		login_click = driver.findElement((SIGN_IN_BTN));
		login_click.click();
		return HomePage.getHomePage();
		/*
		 This will return the object of homepage and getHomePage is defined as getter in homepage
		 */

	}




}
