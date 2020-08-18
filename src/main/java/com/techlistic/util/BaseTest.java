/**
 * 
 */
package com.techlistic.util;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.techlistic.pages.BasePage;
import com.techlistic.pages.CheckOutPage;
import com.techlistic.pages.CustomizeProductPage;
import com.techlistic.pages.LoginPage;
import com.techlistic.pages.MyAccountPage;
import com.techlistic.pages.Page;
import com.techlistic.pages.ProductsListPageTShirts;



/**
 * @author Ashwin BM
 *
 */
public class BaseTest {
	public static WebDriver driver;
	public static Page page;
	public LoginPage loginPage;
	public MyAccountPage myAccountPage;
	public ProductsListPageTShirts productListPageTShirts;
	public CustomizeProductPage customizeProductPage;
	public CheckOutPage checkOutPage;
	
	
	public static WebDriver startApplication(WebDriver driver, String browser, String url) {
		ConfigFileReader config = new ConfigFileReader();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", config.getIEDriverPath());
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", config.getGeckoDriverPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		page = new BasePage(driver);
		return driver;
	}
	
	public static void closeApplication(WebDriver driver) {
		ExcelFileReader.closeExcelWB();
		driver.close();
		driver.quit();
	}

}
