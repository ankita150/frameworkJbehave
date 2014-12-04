package com.framework.project.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.framework.project.util.Property;



public class HomePage {
	private static HomePage homePage ;
	public  WebDriver driver;
	private static WebElement composeBtn;
	private static WebElement enterRecipient;
	private static WebElement enterSubject;
	private static WebElement clickSend;
	public static final By COMPOSE_BTN = By.xpath("//div[text() = 'COMPOSE']");
	public static final By RECIPIENT_LOCATOR = By.xpath("//textarea[@aria-label='To']");
	public static final By SUBJECT_LOCATOR = By.xpath("//input[@placeholder = 'Subject']");
	public static final By SEND_BTN =By.xpath("//div[text() = 'Send']");
	public static final By SEARCH_FIELD = By.xpath("//input[@id = 'gbqfq']");
	public static final By SEARCH_BTN = By.xpath("//button[@id = 'gbqfb']/span");


	//This is a getter which will return the homepage object
	public static HomePage getHomePage() {

		return homePage;
	}

	public HomePage (WebDriver driver){
		this.driver = driver;

	}

	//this will click on compose mail button
	public HomePage composeMail(){
		driver.manage().window().maximize();
		composeBtn = driver.findElement(COMPOSE_BTN);
		composeBtn.click();
		return homePage;

	}

	//this will enter the recipient name
	public HomePage enterRecipientOfMail(){
		enterRecipient=driver.findElement(RECIPIENT_LOCATOR);
		enterRecipient.sendKeys(Property.read("recipientId"));
		enterSubject = driver.findElement(SUBJECT_LOCATOR);
		enterSubject.sendKeys(Property.read("subjectContent"));
		return homePage;

	}

	//this will click on the send button
	public HomePage clickOnSend(){
		clickSend = driver.findElement(SEND_BTN);
		clickSend.click();
		return homePage;
	}

	//it will enter value in the search box
	public HomePage enterInSearchBox() {
		driver.findElement(SEARCH_FIELD).sendKeys(Property.read("searchValue"));
		driver.findElement(SEARCH_BTN).click();
		return homePage;

	}


}


