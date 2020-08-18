/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.techlistic.util.Utility;

/**
 * @author Ashwin BM
 *
 */
public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By emailID = By.id("email");
	private By passwd = By.id("passwd");
	private By loginButton = By.xpath("//button[@id='SubmitLogin']/span");

//	private By loginPageHeader = By.xpath("//h1[@class='page-heading']");
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public MyAccountPage doLogin(String email, String pwd) {
		waitForWebElementPresent(emailID);
		getWebElement(emailID).sendKeys(email);
		getWebElement(passwd).sendKeys(pwd);
		getWebElement(loginButton).click();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		return getInstance(MyAccountPage.class);
	}

}
