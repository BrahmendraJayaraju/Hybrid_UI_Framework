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

        boolean isCI = System.getenv("GITHUB_ACTIONS") != null; // true on GitHub Actions

        if (os.contains("mac") && !isCI) {
            // Local Mac GUI
            System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
            options.addArguments("--start-maximized");
        } else {
            // Windows CI (or any non-Mac CI)
            WebDriverManager.chromedriver().setup();
            options.addArguments("--headless");              // run headless in CI
            options.addArguments("--no-sandbox");            // Linux/Windows sandbox fix
            options.addArguments("--disable-dev-shm-usage"); // memory fix
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

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
