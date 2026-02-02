package com.actiTime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConstant {

	public WebDriver driver;

	@BeforeMethod
	public void precondition() {

	    System.setProperty(
	            "webdriver.chrome.driver",
	            "/Users/brahmendrajayaraju/Downloads/actitimeUI-main/Actitimec/driver/chromedriver"
	    );

	    ChromeOptions options = new ChromeOptions();

	    options.addArguments("--headless=new"); // Use "--headless" for older versions
	    options.addArguments("--disable-gpu"); 
	    options.addArguments("--window-size=1920,1080"); 



	    options.addArguments("--disable-background-networking");
	    options.addArguments("--disable-background-timer-throttling");
	    options.addArguments("--disable-renderer-backgrounding");
	    options.addArguments("--disable-device-discovery-notifications");
	    options.addArguments("--disable-default-apps");
	    options.addArguments("--disable-sync");
	    options.addArguments("--disable-translate");
	    options.addArguments("--disable-features=VizDisplayCompositor");
	    options.addArguments("--disable-features=NetworkService");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--no-first-run");
	    options.addArguments("--start-maximized");

	    // macOS compatibility
	    options.addArguments("--remote-allow-origins=*");

	    driver = new ChromeDriver(options);

	    driver.get("https://online.actitime.com/udel/login.do");
	}


	@AfterMethod
	public void postcondition(ITestResult res) throws IOException

	{

		String name = res.getMethod().getMethodName();

		int val = res.getStatus();

		if (val == 2) {
			GenericUtils.takescreenshot(driver, name);
		}

		driver.quit();
	}

}
