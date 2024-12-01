/*
 * Copyright (c) 2024.
 */

package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.P3_CheckOutPage;
import pageObjects.P1_FormPage;
import pageObjects.P2_ProductsPage;
import utilitties.Utilitties;

public class TC_1 extends base {

	@Test
	public void totalAmountValidation() throws IOException, InterruptedException {

		AndroidDriver driver = capabilities();

		P1_FormPage fpage = new P1_FormPage(driver);
		// fpage.getNameField().sendKeys("kakon");
		fpage.nameField.click();
		fpage.nameField.sendKeys("Hesham Abd Elhamed");

		driver.hideKeyboard();

		fpage.femaleOption.click();
		// fpage.maleOption.click();

		fpage.dropDownClick.click();

		Utilitties u = new Utilitties(driver);
		u.scrollToText("Egypt");

		fpage.ChooseCountry("Egypt").click();

		fpage.letsShop.click();

		P2_ProductsPage pPage = new P2_ProductsPage(driver);

		pPage.addToCart.get(0).click();
		pPage.addToCart.get(0).click();

		pPage.cart.click();

		Thread.sleep(4000);

		P3_CheckOutPage cPage = new P3_CheckOutPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(100));
		wait.until(ExpectedConditions.visibilityOfAllElements( cPage.productList));
		Assert.assertTrue( cPage.productList.size()>0);
		Assert.assertEquals(cPage.products.get(0).getText(),pPage.products.get(0).getText());
		Assert.assertEquals(cPage.products.get(1).getText(),pPage.products.get(1).getText());


		double sum = 0;
		int count = cPage.productList.size();

		for (int i = 0; i < count; i++) {
			String amount1 = cPage.productList.get(i).getText();
			double amountValue1 = getAmount(amount1);
			sum = sum + amountValue1;
		}
		System.out.println("SumOfProducts individually: " + sum);

		String total = cPage.total.getText();
		double totalValue = getAmount(total);
		System.out.println("TotalValue from the application: " + totalValue);

		Assert.assertEquals(sum, totalValue);

		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.quit();

	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
	}

}
