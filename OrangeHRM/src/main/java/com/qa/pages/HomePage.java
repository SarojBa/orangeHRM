package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
		@FindBy(xpath="//a[contains(text(),'Welcome Admin')]") WebElement welcomeLabel;
		@FindBy(id="menu_admin_viewAdminModule") WebElement adminLink;
		
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifyWelcomeLabel(){
			return welcomeLabel.isDisplayed();
		}
		
		public AdminPage clickOnAdminLink(){
			adminLink.click();
			return new AdminPage();
		}
		

}
