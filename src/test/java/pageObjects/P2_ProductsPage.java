// BEGIN
/*
 * This class represents the Products Page in the Appium project for the General Store.
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
    
    // Constructor to initialize the driver and set up the PageFactory
    public P2_ProductsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Initialize elements using AppiumFieldDecorator for Android and iOS platforms.
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cart; // WebElement for the 'cart' button

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    public List<WebElement> addToCart; // List of WebElements for 'ADD TO CART' buttons

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
    public List<WebElement> products; // List of WebElements for product names
}
// END
