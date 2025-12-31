package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.generic.BasePage;

public class LoginPage extends BasePage {

	@FindBy(name = "username")
	private WebElement usernameTb;

	@FindBy(name = "pwd")
	private WebElement passwordTb;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginbtn;

	@FindBy(xpath = "//nobr[.='actiTIME 2026 Online']")
	private WebElement version;

	@FindBy(xpath = "//span[.='Username or Password is invalid. Please try again.']")
	private WebElement errmsg;

	public LoginPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	public void enterusername(String un) {
		usernameTb.sendKeys(un);
	}

	public void enterpassword(String pw) {
		passwordTb.sendKeys(pw);
	}

	public void clickonlogin() {
		loginbtn.click();
	}

	public void verifytitle(String etitle) {
		verifytitlepageclass(etitle);

	}

	public String verifyerrormessage() {
		Veriftelemnt(errmsg);
		String actualerrmeg = errmsg.getText();

		return actualerrmeg;

	}

	public String verifyeversion() {

		String aversion = version.getText();

		return aversion;

	}

}
