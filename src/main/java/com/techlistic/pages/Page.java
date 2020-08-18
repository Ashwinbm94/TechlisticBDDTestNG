/**
 * 
 */
package com.techlistic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.techlistic.util.Utility;

/**
 * @author Ashwin BM
 *
 */

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Utility.IMPLICIT_WAIT); 
	}
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getWebElement(By locator);
	
	public abstract void waitForWebElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public abstract void waitForWebElementVisibility(By locator);
	
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
	}

}
