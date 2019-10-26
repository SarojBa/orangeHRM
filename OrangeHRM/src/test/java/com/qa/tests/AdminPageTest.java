package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AdminPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtil;


public class AdminPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	String sheetName = "users";
	
	public AdminPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		//adminPage = new AdminPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		adminPage = homePage.clickOnAdminLink();
	}
	
	@Test(priority=1)
	public void verifyAdminPageURLTest(){
		String adminURL = adminPage.verifyAdminPageURL();
		Assert.assertEquals(adminURL, "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers","not matched urls");
	}
	
	@Test(priority=2)
	public void clickAddBtnTest() throws InterruptedException{
		adminPage.clickOnAddButton();
	}
	
	@DataProvider
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getOrangeHRMTestData")
	public void validateCreateNewUser(String userRole, String empName, String userName, String password, String confirmPwd) throws InterruptedException{
		adminPage.clickOnAddButton();
		adminPage.createNewUser(userRole,empName,userName,password,confirmPwd);
		String btext = adminPage.validateUser();
		Assert.assertTrue(btext.contains(userName),"user not found");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
		
	
	
	
}
