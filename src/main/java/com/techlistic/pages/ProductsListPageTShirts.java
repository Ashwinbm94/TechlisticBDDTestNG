/**
 * 
 */
package com.techlistic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Ashwin BM
 *
 */
public class ProductsListPageTShirts extends BasePage{


	public ProductsListPageTShirts(WebDriver driver) {
		super(driver);
	}
	
	private By productTShirt= By.xpath("//ul[@class='product_list grid row']/li[1]");
	private By moreButton = By.xpath("//ul[@class='product_list grid row']/li[1]//span[contains(text(),'More')]");
	
	public String getProductListPageTitle() {
		return getPageTitle();
	}
	
	//Move the cursor over thproductTShirte Item and click on More button once it is visible
	public CustomizeProductPage clickOnCustomizeProduct() {
		waitForWebElementPresent(productTShirt);
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(productTShirt)).build().perform();
		waitForWebElementVisibility(moreButton);
		
		getWebElement(moreButton).click();
		
		return getInstance(CustomizeProductPage.class);
				
	}

}
