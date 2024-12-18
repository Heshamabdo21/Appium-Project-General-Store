// BEGIN

/*
 * This class represents the Page Object for the Checkout page in the mobile application.
 * It contains elements and methods related to the Checkout page.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P3_CheckOutPage {

    // Constructor to initialize the Page Object with the driver
    public P3_CheckOutPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // List of WebElements representing the total amount displayed on the Checkout page
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public List<WebElement> totalAmount;

    // List of WebElements representing the product prices displayed on the Checkout page
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productList; // public List<WebElement> name; -->for FindByElements

    // WebElement representing the total amount label on the Checkout page
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement total;

    // WebElement representing the product name displayed on the Checkout page
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
    public WebElement productName;
    
// END
	public List<WebElement> products;
}
