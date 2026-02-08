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
    public void precondition() throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        ChromeOptions options = new ChromeOptions();

        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
            options.addArguments("--start-maximized");
        } else {
            // Linux CI
            WebDriverManager.chromedriver().setup();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");

            // Add a short delay after page load for CI
            Thread.sleep(5000); // 2 seconds
        }

        driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/udel/login.do");

        // Optional: another tiny wait to make sure login elements are present
        if (!os.contains("mac")) {
            Thread.sleep(5000);
        }
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
