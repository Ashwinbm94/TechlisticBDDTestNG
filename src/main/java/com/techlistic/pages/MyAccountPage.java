/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.techlistic.util.Utility;

/**
 * @author Ashwin BM
 *
 */
public class MyAccountPage extends BasePage{


	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private By menuWomen = By.xpath("//a[@title='Women']");
	private By womenTshirtsSubMenu = By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='T-shirts']");
	
	
	public String getMyAccountPageTitle() {
		return getPageTitle();
	}
	
	public void mouseHoverOnWomenMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(menuWomen)).build().perform();
	}
	
	public void clickOnWomenTShirtsSubMenu() {
		waitForWebElementVisibility(womenTshirtsSubMenu);
		getWebElement(womenTshirtsSubMenu).click();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public ProductsListPageTShirts clickOnWomensTshirts() {
		mouseHoverOnWomenMenu();
		clickOnWomenTShirtsSubMenu();
		
		return getInstance(ProductsListPageTShirts.class);
	}
	
	

}
