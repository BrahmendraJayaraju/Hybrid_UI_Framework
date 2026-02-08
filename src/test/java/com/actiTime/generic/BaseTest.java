package com.actiTime.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest implements AutoConstant {

    public WebDriver driver;

    @BeforeMethod
    public void precondition() {

        String os = System.getProperty("os.name").toLowerCase();

        ChromeOptions options = new ChromeOptions();

        if (os.contains("mac")) {
            // Mac: use your local chromedriver
            System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
            // optional: run GUI Chrome
            options.addArguments("--start-maximized");
        } else {
            // Linux (GitHub Actions VM): headless + WebDriverManager
            WebDriverManager.chromedriver().setup();
            options.addArguments("--headless");              // run headless
            options.addArguments("--no-sandbox");            // Linux sandbox fix
            options.addArguments("--disable-dev-shm-usage"); // memory fix
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        // Common options for all platforms
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
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/udel/login.do");
    }

    @AfterMethod
    public void postcondition(ITestResult res) throws IOException {
        String name = res.getMethod().getMethodName();
        int val = res.getStatus();

        if (val == 2) {
            GenericUtils.takescreenshot(driver, name);
        }

        driver.quit();
    }
}
