package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AdminPage;
import com.qa.pages.HomePage;
import com.qa.pages.LeavePage;
import com.qa.pages.LoginPage;

public class LeavePageTest extends TestBase {
	
	LoginPage loginPage ;
	HomePage homePage;
	LeavePage leavePage;
	
	public LeavePageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		leavePage = new LeavePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void clickLeaveTabTest(){
		leavePage.clickOnLeaveTab();
	}
	
	@Test(priority=2)
	public void verifyLeavePageURLTest(){
		String url = leavePage.verifyLeavePageURL();
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveList");
	}
	
	@Test(priority=3)
	public void verifyLeaveListTest(){
		leavePage.searchLeaveListByDate("2015-10-01","2015-10-10");
	}
	
	
	@AfterClass
	public void def(){
		System.out.println("quit");
		
	}

}
