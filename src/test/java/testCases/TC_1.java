


/*
 * This class represents a test case for validating the total amount in a shopping application.
 * It includes setting up the driver, interacting with form fields, and performing validation.
 */
 
package testCases; // Declaring the package name for the test case class

import java.io.IOException; // Importing the IOException class for handling input/output exceptions
import java.time.Duration; // Importing the Duration class for representing time-based values

import org.openqa.selenium.support.ui.ExpectedConditions; // Importing ExpectedConditions class for defining the conditions for waiting
import org.openqa.selenium.support.ui.WebDriverWait; // Importing WebDriverWait class for implementing waits
import org.testng.Assert; // Importing Assert class for performing assertions
import org.testng.annotations.Test; // Importing Test annotation from TestNG framework

import base.base; // Importing the base class for test setup
import io.appium.java_client.android.AndroidDriver; // Importing AndroidDriver class from Appium for Android driver interactions
import io.appium.java_client.android.nativekey.AndroidKey; // Importing AndroidKey class for native Android key events
import io.appium.java_client.android.nativekey.KeyEvent; // Importing KeyEvent class for Android key events
import pageObjects.P3_CheckOutPage; // Importing CheckOutPage class from pageObjects package for checkout page interactions

import pageObjects.P1_FormPage; // Importing FormPage class from pageObjects package
import pageObjects.P2_ProductsPage; // Importing ProductsPage class from pageObjects package
import utilitties.Utilitties; // Importing Utilitties class for utility functions

public class TC_1 extends base {

    @Test
    public void totalAmountValidation() throws IOException, InterruptedException {

        // Initialize the Android driver with capabilities
        AndroidDriver driver = capabilities();

        // Instantiate the Form Page object
        P1_FormPage fpage = new P1_FormPage(driver);
        
        // Click on the name field and enter the name
        fpage.nameField.click();
        fpage.nameField.sendKeys("Hesham Abd Elhamed");

        // Hide the keyboard after entering the name
        driver.hideKeyboard();

        // Select the female option on the form
        fpage.femaleOption.click();
        
		// fpage.maleOption.click();

// BEGIN
        // Click on the dropdown element on the page
        fpage.dropDownClick.click();

        // Create a new instance of Utilitties class with driver as a parameter
        Utilitties u = new Utilitties(driver);
        
        // Scroll to find and click on the element with text "Egypt"
        u.scrollToText("Egypt");

        // Click on the element with text "Egypt" to choose the country
        fpage.ChooseCountry("Egypt").click();

        // Click on the "Let's Shop" button
        fpage.letsShop.click();

        // Create a new instance of P2_ProductsPage class with driver as a parameter
        P2_ProductsPage pPage = new P2_ProductsPage(driver);

        // Click on the "Add to Cart" button for the first product twice
        pPage.addToCart.get(0).click();
        pPage.addToCart.get(0).click();

        // Click on the "Cart" button to view the cart
        pPage.cart.click();

        // Pause the execution for 4000 milliseconds (4 seconds)
        Thread.sleep(4000);

        // Create a new instance of P3_CheckOutPage class with driver as a parameter
        P3_CheckOutPage cPage = new P3_CheckOutPage(driver);
        
        // Create a new WebDriverWait instance with a timeout of 10 seconds and polling interval of 100 milliseconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        
        // Wait until all elements in the product list are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(cPage.productList));
        
        // Assert that the product list size is greater than 0
        Assert.assertTrue(cPage.productList.size() > 0);
        
        // Assert that the text of the first product in the checkout page matches the text of the first product in the products page
        Assert.assertEquals(cPage.products.get(0).getText(), pPage.products.get(0).getText());
        
        // Assert that the text of the second product in the checkout page matches the text of the second product in the products page
        Assert.assertEquals(cPage.products.get(1).getText(), pPage.products.get(1).getText());

        // Initialize variables for sum and count of products in the cart
        double sum = 0;
        int count = cPage.productList.size();

        // Iterate through each product in the cart
        for (int i = 0; i < count; i++) {
            // Get the text representing the amount of the product
            String amount1 = cPage.productList.get(i).getText();
            
            // Parse the amount value from the text
            double amountValue1 = getAmount(amount1);
// END
			sum = sum + amountValue1;
// BEGIN

        }
        System.out.println("SumOfProducts individually: " + sum); // Print the sum of products individually

        String total = cPage.total.getText(); // Get the total value from the application
        double totalValue = getAmount(total); // Convert the total value to a double using the getAmount method
        System.out.println("TotalValue from the application: " + totalValue); // Print the total value from the application

        Assert.assertEquals(sum, totalValue); // Assert that the sum equals the total value

        driver.pressKey(new KeyEvent(AndroidKey.HOME)); // Simulate pressing the HOME key on the Android device
        driver.quit(); // Quit the driver

    }

    // Method to extract the amount value from a string
    public static double getAmount(String value) {
        value = value.substring(1); // Remove the currency symbol from the value
        double amountValue = Double.parseDouble(value); // Parse the value to a double
        return amountValue; // Return the amount value as a double
    }

}
// END
