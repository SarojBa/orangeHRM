package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory OR
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement loginButton;
	
	//initializing page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new HomePage();
	}

}
