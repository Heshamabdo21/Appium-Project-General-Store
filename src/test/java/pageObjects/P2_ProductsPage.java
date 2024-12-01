/*
 * Copyright (c) 2024.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P2_ProductsPage {
	AppiumDriver driver;
	public P2_ProductsPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // android and ios platform.
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	public List<WebElement> addToCart;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
	public List<WebElement> products;

}