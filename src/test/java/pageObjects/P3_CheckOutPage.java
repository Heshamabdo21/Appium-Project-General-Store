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

public class P3_CheckOutPage {

	public P3_CheckOutPage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public List<WebElement> totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList; // public List<WebElement> name; -->for FindByElements

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement total;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
	public List<WebElement> products;
}
