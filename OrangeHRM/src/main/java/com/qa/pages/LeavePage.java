package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LeavePage extends TestBase {
	
	String leaveStatus;
	
	@FindBy(xpath="//b[contains(text(),'Leave')]") WebElement LeaveLink;
	@FindBy(xpath="//*[@id='frmFilterLeave']/fieldset/ol/li[1]/img") WebElement FromIcon;
	@FindBy(xpath="//*[@id='frmFilterLeave']/fieldset/ol/li[2]/img") WebElement ToIcon;
	@FindBy(xpath="//input[@id='calFromDate']") WebElement FromDateInput;
	//@FindBy(xpath="//label[contains(text(),'"+leaveStatus+"')]") WebElement LeaveStatus;
	@FindBy(id="leaveList_txtEmployee_empName") WebElement empName;
	@FindBy(id="leaveList_cmbSubunit") WebElement selectSubunit;
	@FindBy(xpath="//input[@name='btnSearch']") WebElement searchButton;
	@FindBy(xpath="//input[@name='btnReset']") WebElement resetButton;
	
	public LeavePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLeaveTab(){
		LeaveLink.click();
	}
	public String verifyLeavePageURL(){
		return driver.getCurrentUrl();
	}
	
	public void searchLeaveListByDate(String fromDate,String toDate){
		FromIcon.click();
		FromDateInput.clear();
		FromDateInput.sendKeys(fromDate);
		
	}
	
	
	

}
