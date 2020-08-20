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
	
	private By loginErrorMsg = By.xpath("//script[@type='text/javascript'][contains(text(),'You must be logged in to manage your wishlist.')]");

	
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
	
	public void proceedToSignin() {
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
	}
	
	public void proceedToAddress() {
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
	}
	
	public void proceedToShipping() {
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
	}
	
	public void acceptTermsOfServiceInShippingTab() {
		getWebElement(termsOfService).click();
	}
	
	public void proceedToPayment() {
		getWebElement(proceedToCheckoutbtn).click();
		waitTillShoppingCartPageLoads();
	}
	
	public void selectPaybyBankWire() {
		getWebElement(paybyBankWire).click();
		waitTillShoppingCartPageLoads();
	}
	
	public void clickOnConfirmMyOrder() {
		getWebElement(confirmOrderbtn).click();
		waitTillShoppingCartPageLoads();
	}
	
	public String verifyLoginMandatoryErrorMessage() {
		String bodyText = getWebElement(loginErrorMsg).getText();
		return bodyText;
	}
	
	public void orderCheckoutNonSigninUser() {
		proceedToSignin();
		
	}
	
	public void orderCheckoutSignedinUser() {
		proceedToAddress();
		proceedToShipping();
		acceptTermsOfServiceInShippingTab();
		proceedToPayment();
		selectPaybyBankWire();
		clickOnConfirmMyOrder();
			
	}
	
	
}
