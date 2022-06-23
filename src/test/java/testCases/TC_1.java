package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.P3_CheckOutPage;
import pageObjects.P1_FormPage;
import pageObjects.P2_ProductsPage;
import utilitties.Utilitties;

public class TC_1 extends base {

	@Test
	public void totalAmountValidation() throws IOException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities();

		P1_FormPage fpage = new P1_FormPage(driver);
		// fpage.getNameField().sendKeys("kakon");
		fpage.nameField.sendKeys("kakon");

		driver.hideKeyboard();

		fpage.femaleOption.click();
		// fpage.maleOption.click();

		fpage.dropDownClick.click();

		Utilitties u = new Utilitties(driver);
		u.scrollToText("Bangladesh");

		fpage.ChooseCountryBangladesh.click();

		fpage.letsShop.click();

		P2_ProductsPage pPage = new P2_ProductsPage(driver);

		pPage.addToCart.get(0).click();
		pPage.addToCart.get(0).click();

		pPage.cart.click();

		Thread.sleep(4000);

		P3_CheckOutPage cPage = new P3_CheckOutPage(driver);

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
