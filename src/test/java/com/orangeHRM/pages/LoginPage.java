package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.generic.BasePage;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTb;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTb;

	@FindBy(xpath = "//button[.=' Login ']")
	private WebElement loginbtn;

	
	@FindBy(xpath = "//h5[.='Login']")
	private WebElement loginelement;
	
	

	@FindBy(xpath = "//p[.='Invalid credentials']")
	private WebElement errmsg;

	public LoginPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	public void enterusername(String un)  {
		
		Veriftelemnt(usernameTb);
	
		usernameTb.sendKeys(un);
	}

	public void enterpassword(String pw) {
		
		Veriftelemnt(passwordTb);
	
		passwordTb.sendKeys(pw);
	}

	public void clickonlogin() {
		Veriftelemnt(loginbtn);
		loginbtn.click();
	}

	public void verifytitle(String etitle)
	{
		
		verifytitlepageclass(etitle);

	}

	public String verifyerrormessage() {
		Veriftelemnt(errmsg);
		String actualerrmeg = errmsg.getText();

		return actualerrmeg;

	}
	
public void verifylogintext(String logtext)
	
	{
		verifyText(loginelement,logtext);
	}



}
