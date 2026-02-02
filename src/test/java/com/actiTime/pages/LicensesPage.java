package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.generic.BasePage;

public class LicensesPage extends BasePage {

	@FindBy(xpath= "(//div[@class='pages-navigation-Popups-ProfilePopup-buttonsGroup--dKHJND4D'])[1]")
	private WebElement avatar;

	@FindBy(xpath = "//div[.='Logout']")
	private WebElement logoutbtn;

	public LicensesPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}

	public void clickavatar() {
		avatar.click();
	}

	public void clicklogout() {
		logoutbtn.click();
	}

}
