package com.actiTime.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public void verifytitlepageclass(String etitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(ExpectedConditions.titleIs(etitle));

			Reporter.log("title is matching", true);

		} catch (Exception e) {
			Reporter.log("title is not matching", true);
			Reporter.log("actual title is : " + driver.getTitle() + " expected titlr is : " + etitle);

			Assert.fail();
		}

	}

	public void Veriftelemnt(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("element is present");
		}

		catch (Exception e) {
			Reporter.log("element is not present", true);
			Assert.fail();
		}

	}
	
	
	public void verifyText(WebElement loginwebelement, String expectedText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    try {
	        
			wait.until(ExpectedConditions.visibilityOf(loginwebelement));
	        	 String actualText = loginwebelement.getText();

	 	        Reporter.log("Actual text   : " + actualText, true);
	 	        Reporter.log("Expected text : " + expectedText, true);

	 	        Assert.assertEquals(actualText, expectedText, "Text mismatch");
	        	
	        

	       

	    } catch (Exception e) {
	        Reporter.log("Failed to verify text for locator : " + loginwebelement, true);
	        Assert.fail("Unable to get or verify text");
	    }
	}

	

}
