package com.techlistic.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility {
	
	public static int IMPLICIT_WAIT = 30;
	public static int PAGE_LOAD_TIMEOUT = 30;
	
	public static String captureScreenShot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName
				+ getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(source, new File(screenShotPath));
		}catch (Exception e) {
			System.out.println("Error in capturing Screenshot: " + e.getMessage());
		}
		return screenShotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	public static void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, Utility.PAGE_LOAD_TIMEOUT);
		wait.until(pageLoadCondition);
	}

	public static void clickOnInvisibleElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public static void enterTheValueUsingJS(WebDriver driver, WebElement ele, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';", ele);
	}

}
