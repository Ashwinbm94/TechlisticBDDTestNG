/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.techlistic.util.Utility;

/**
 * @author Ashwin BM
 *
 */
public class CustomizeProductPage extends BasePage {

	/**
	 * @param driver
	 */
	public CustomizeProductPage(WebDriver driver) {
		super(driver);
	}

	private By increaseQty = By.xpath("//i[@class='icon-plus']");
	private By selectSizeDropdown = By.xpath("//select[@id='group_1']");
	private By colorOrange = By.xpath("//a[@name='Orange']");
	private By colorBlue = By.xpath("//a[@name='Blue']");
	private By addToCart = By.xpath("//button[@name='Submit']//span[contains(text(),'Add to cart')]");
	private By proceedToCheckoutBtn = By.xpath("//a[@title='Proceed to checkout']//span");

	public String getCustomizeProductPageTitle() {
		return getPageTitle();
	}

	// Choose the Quantity of products to be purchased
	public void increaseProductQty(int quantity) {
		for (int i = 1; i < quantity; i++) {
			getWebElement(increaseQty).click();
		}
	}

	// Choose size of the product from the drop down
	public void selectSize(String size) {
		Select select = new Select(getWebElement(selectSizeDropdown));
		select.selectByVisibleText(size);
	}

	// Select Color of the product
	public void selectColor(String color) throws Exception {
		if (color.equalsIgnoreCase("blue")) {
			getWebElement(colorBlue).click();
		} else if (color.equalsIgnoreCase("orange")) {
			getWebElement(colorOrange).click();
		} else {
			throw new Exception("Color Provided is not available, please select only the availabe color");
		}
	}

	// Customize and Add Product to cart
	public CheckOutPage customizeAndAddProductToCart(int quantity, String size, String color) {
		driver.manage().timeouts().pageLoadTimeout(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		increaseProductQty(quantity);
		selectSize(size);
		try {
			selectColor(color);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getWebElement(addToCart).click();
		waitForWebElementVisibility(proceedToCheckoutBtn);
		getWebElement(proceedToCheckoutBtn).click();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		return getInstance(CheckOutPage.class);

	}

}
