package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage ;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		//System.out.println("title verified");
		
	}
	
	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		//System.out.println("logged in successfully");
	}
	
	@Test(priority=3)
	public void testM(){
		System.out.println(".............");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
