package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.generic.BasePage;

public class DashboardPage extends BasePage {

	@FindBy(xpath= "//li[@class='oxd-userdropdown']")
	private WebElement avatar;

	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutbtn;
	
	
	@FindBy(xpath = "//h6[.='Dashboard']")
	private WebElement dashelement;
	
	
	
	

	public DashboardPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}
	
	public void verifydashboardtext(String dashboardtitle)
	
	{
		verifyText(dashelement,dashboardtitle);
	}
	
	


	public void clickavatar() {
		Veriftelemnt(avatar);
		avatar.click();
	}

	public void clicklogout() throws InterruptedException {
		
		logoutbtn.click();
	}

}
