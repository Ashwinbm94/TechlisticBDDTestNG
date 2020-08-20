/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	private By menuWomen = By.xpath("//a[@title='Women']");
	private By womenTshirtsSubMenu = By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='T-shirts']");
	
	public String getIndexPageTitle() {
		return getPageTitle();
	}
	
	public WebElement getSignInWebElement() {
		return getWebElement(signInLink);
	}
	
	public void mouseHoverOnWomenMenu() {
		Actions actions = new Actions(driver);
		actions.moveToElement(getWebElement(menuWomen)).build().perform();
	}
	
	public void clickOnWomenTShirtsSubMenu() {
		waitForWebElementVisibility(womenTshirtsSubMenu);
		getWebElement(womenTshirtsSubMenu).click();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public ProductsListPageTShirts navigateToWomensTshirtsFromIndexPage() {
		mouseHoverOnWomenMenu();
		clickOnWomenTShirtsSubMenu();
		
		return getInstance(ProductsListPageTShirts.class);
	}
	
	public LoginPage clickSignIn() {
		getSignInWebElement().click();
		driver.manage().timeouts().pageLoadTimeout(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return getInstance(LoginPage.class);
	}
	
}
