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
public class ProductsListPageTShirts extends BasePage{


	public ProductsListPageTShirts(WebDriver driver) {
		super(driver);
	}
	
	private By productTShirt= By.xpath("//ul[@class='product_list grid row']/li[1]");
	private By moreButton = By.xpath("//ul[@class='product_list grid row']/li[1]//span[contains(text(),'More')]");
	private By addToCart = By.xpath("//ul[@class='product_list grid row']//li[1]//span[contains(text(),'Add to cart')]");
	private By addToWishList = By.xpath("//ul[@class='product_list grid row']//li[1]//a[contains(text(),'Add to Wishlist')]");
	private By proceedToCheckoutBtn = By.xpath("//a[@title='Proceed to checkout']//span");
	private By addToWishListErrorMsg = By.xpath("//p[@class='fancybox-error']");
	
	public String getProductListPageTitle() {
		return getPageTitle();
	}
	
	public void mouseHoverOnProductTShirt() {
		waitForWebElementPresent(productTShirt);
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(productTShirt)).build().perform();
	}
	
	//Move the cursor over thproductTShirt Item and click on Add to Cart button once it is visible
		public void clickOnAddToCart() {
			mouseHoverOnProductTShirt();
			waitForWebElementVisibility(addToCart);
			getWebElement(addToCart).click();			
		}
		
		public CheckOutPage proceedToCheckout() {
			waitForWebElementVisibility(proceedToCheckoutBtn);
			getWebElement(proceedToCheckoutBtn).click();
			driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

			return getInstance(CheckOutPage.class);
		}
		
		public void clickOnAddToWishList() {
			mouseHoverOnProductTShirt();
			waitForWebElementVisibility(addToWishList);
			getWebElement(addToWishList).click();			
		}
		
		public String getAddToWishListErrorMsg() {
			return getWebElement(addToWishListErrorMsg).getText();
		}
		
	
	//Move the cursor over thproductTShirt Item and click on More button once it is visible
	public CustomizeProductPage clickOnCustomizeProduct() {
		mouseHoverOnProductTShirt();
		waitForWebElementVisibility(moreButton);
		getWebElement(moreButton).click();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		return getInstance(CustomizeProductPage.class);
				
	}

}
