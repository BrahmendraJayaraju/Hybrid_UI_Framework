package com.orangeHRM.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {

	public static void takescreenshot(WebDriver driver, String name) throws IOException {
		try {
			TakesScreenshot t = (TakesScreenshot) driver;

			File src = t.getScreenshotAs(OutputType.FILE);

			File des = new File("./Screenshots/" + name + ".png");

			FileUtils.copyFile(src, des);
		} catch (Exception e) {

		}

	}

	public static void selectclassmethod(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void actionclassmethod(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();

	}

}
