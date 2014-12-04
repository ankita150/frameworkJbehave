package com.framework.project.classes;

import java.io.IOException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import com.framework.project.pages.HomePage;
import com.framework.project.pages.LoginPage;
import com.framework.project.util.Property;



public class Test extends BaseClass{
	HomePage homePage;
	LoginPage logInPage;



	@Given("I have opened the gmail url")
	public void url(){
		driver.get(Property.read("url"));

	}

	@When("I login with username and password")
	public void login(){
		logInPage = new LoginPage(driver);
		logInPage.enterUsername();
		logInPage.enterPassword();
		logInPage.loginBtn();

	}
	@Then("I should be able to compose a mail")
	public void homepage() throws InterruptedException, IOException{
		homePage = new HomePage(driver);
		homePage.composeMail();
	}
	@When("I enter the recipient and subject")
	public void enterContent(){
		homePage.enterRecipientOfMail();
	}

	@Then("I should be able to click on Send Button")
	public void clickSend(){
		homePage.clickOnSend();
	}

	@When("I enter text in search box and click on search")
	public void enterText() throws InterruptedException{
		homePage.enterInSearchBox();
	}
}

