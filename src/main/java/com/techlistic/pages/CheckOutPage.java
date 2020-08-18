/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Ashwin BM
 *
 */
public class CheckOutPage extends BasePage{

	/**
	 * @param driver
	 */
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	private By proceedToCheckoutbtn = By.xpath("//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]");
//	private By pageHeading = By.xpath("//h1[@class='page-heading']");
	private By termsOfService = By.xpath("//input[@id='cgv']");
	private By paybyBankWire = By.xpath("//a[@title='Pay by bank wire']");
	private By confirmOrderbtn = By.xpath("//button[@type='submit']/span[contains(text(),'I confirm my order')]");
	private By OrderConfSuccessMsg = By.xpath("//strong[@class='dark'][contains(text(),'Your order on My Store is complete.')]");

	
	public String getCheckoutPageTitle() {
		return getPageTitle();
	}
	
	public void waitTillShoppingCartPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	public String getSuccessMessage() {
	String successMsg = getWebElement(OrderConfSuccessMsg).getText();
	return successMsg;
	}
	
	public void orderCheckout() {
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
		getWebElement(termsOfService).click();
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
		getWebElement(paybyBankWire).click();
		waitTillShoppingCartPageLoads();
		getWebElement(confirmOrderbtn).click();
		waitTillShoppingCartPageLoads();
		
		
	}
	
	
}
