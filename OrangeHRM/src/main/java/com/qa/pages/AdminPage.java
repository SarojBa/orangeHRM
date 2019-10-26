package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class AdminPage extends TestBase{
	
	
	@FindBy(id="btnAdd") WebElement addButton;
	
	@FindBy(id="systemUser_employeeName_empName") WebElement empName;
	@FindBy(id="systemUser_userName") WebElement adminUserName;
	@FindBy(id="systemUser_password") WebElement adminPwd;
	@FindBy(id="systemUser_confirmPassword") WebElement adminConfirmPwd;
	@FindBy(id="btnSave") WebElement saveButton;
	
	
	public AdminPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAdminPageURL(){
		return driver.getCurrentUrl();
	}
	
	
	public void clickOnAddButton() throws InterruptedException{
		Thread.sleep(4000);
		System.out.println("trying to click...");
		addButton.click();
		System.out.println("finally clicked...");
	}
	
	public void createNewUser(String role, String eName, String uName, String aPwd, String aConfirmPwd){
		
		Select select = new Select(driver.findElement(By.id("systemUser_userType")));
		select.selectByVisibleText(role);
		empName.sendKeys(eName);
		adminUserName.sendKeys(uName);
		adminPwd.sendKeys(aPwd);
		adminConfirmPwd.sendKeys(aConfirmPwd);
		saveButton.click();
		
	}
	
	public String validateUser(){
		String bodyText = driver.findElement(By.tagName("tbody")).getText();
		return bodyText;
	}
	

	/*public void navigateAdminMenu() throws InterruptedException{
		adminMenu.click();
		Thread.sleep(3000);
	}
	
	public void clickAddButton(){
		addButton.click();
	}
	
	public void addUser(String userRole, String strEmpName) throws InterruptedException{
		
		empnameTextbox.sendKeys(strEmpName);
		Thread.sleep(3000);
		
		usernameTextbox.sendKeys(prop.getProperty("username"));
		Thread.sleep(3000);
		saveButton.click();
		Thread.sleep(3000);
		
	
	}
	public void verifyAddUser() throws InterruptedException{
		
		WebElement table = driver.findElement(By.tagName("tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		List<WebElement> cols = table.findElement(By.tagName("tr")).findElements(By.tagName("td"));
		System.out.println(cols.size());
		int j=2;
		
		Thread.sleep(3000);
		for(int i=2; i<=rows.size();i++){
		
				WebElement userText = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]/a"));
				String user = userText.getText();
				
				if(user.equals(prop.getProperty("username"))){
					System.out.println("Added user " +user+ " is present in the list...");
					break;
				}
				
		}
	}
	
	public void deleteUser(String strUser) throws InterruptedException{
		
		userTextbox.sendKeys(strUser);
		searchButton.click();
		Thread.sleep(3000);
		chkBox.click();
		Thread.sleep(2000);
		deleteButton.click();
		
		okButton.click();
		
	}
	
	public void verifyDeleteUser(String strUser) throws InterruptedException{
		
		WebElement table = driver.findElement(By.tagName("tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		List<WebElement> cols = table.findElement(By.tagName("tr")).findElements(By.tagName("td"));
		System.out.println(cols.size());
		
		int j=2;
		
		Thread.sleep(3000);
		for(int i=2; i<=rows.size();i++){
		
				WebElement userText = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]/a"));
				String user = userText.getText();
				System.out.println(user);
				
				    if(user.equals(strUser))
					{
					System.out.println("so user is not deleted...");
					break;
					}		
					
		}
	
		
		
	}

*/
	
	

}
