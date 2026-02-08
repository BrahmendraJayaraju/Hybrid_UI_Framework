package com.actiTime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest implements AutoConstant {

    public WebDriver driver;

    @BeforeMethod
    public void precondition() {
        ChromeOptions options = new ChromeOptions();

        // Detect if running on GitHub Actions
        boolean isGitHubActions = System.getenv("GITHUB_ACTIONS") != null;

        if (isGitHubActions) {
            // Headless for GitHub Actions
            WebDriverManager.chromedriver().setup();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080"); // ensure elements visible
        } else {
            // Local Mac / local Jenkins → use GUI Chrome
            System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
            options.addArguments("--start-maximized");
        }

        try {
            driver = new ChromeDriver(options);
            driver.get("https://online.actitime.com/udel/login.do");

            // Explicit wait for login page to load fully
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); // adjust selector if needed

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Precondition setup failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void postcondition(ITestResult res) throws IOException {
        String name = res.getMethod().getMethodName();
        int val = res.getStatus();

        if (val == ITestResult.FAILURE) {
            GenericUtils.takescreenshot(driver, name);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
