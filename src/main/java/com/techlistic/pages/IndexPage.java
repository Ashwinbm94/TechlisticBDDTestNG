/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techlistic.util.Utility;

/**
 * @author Ashwin BM
 *
 */
public class IndexPage extends BasePage{

	/**
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		super(driver);
	}
	
	private By signInLink = By.className("login");
	
	public WebElement getSignInWebElement() {
		return getWebElement(signInLink);
	}
	
	public LoginPage clickSignIn() {
		getSignInWebElement().click();
		driver.manage().timeouts().pageLoadTimeout(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return getInstance(LoginPage.class);
	}
	
}
