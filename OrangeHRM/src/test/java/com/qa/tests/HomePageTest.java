package com.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AdminPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;

	public HomePageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "OrangeHRM","not matched");
		//System.out.println("first test case passed....");
	}
	
	@Test(priority=2)
	public void verifyWelcomeLabelTest(){
		boolean flag = homePage.verifyWelcomeLabel();
		Assert.assertTrue(flag);
		//System.out.println("second test case passed....");
	}
	
	@Test(priority=3)
	public void verifyAdminLinkTest(){
		adminPage = homePage.clickOnAdminLink();
		//System.out.println("third test case passed....");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
