// BEGIN

/*
 * This class represents the Page Object for the form page in the mobile application.
 * It contains elements and methods related to the form page.
 */

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P1_FormPage {
    AppiumDriver driver;
    
    // Constructor to initialize the driver and PageFactory
    public P1_FormPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        // PageFactory.initElements(driver, this); // Alternative way without AppiumFieldDecorator
    }

    // Element representing the name field on the form page
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField; // public List<WebElement> name; -->for FindByElements

    // Element representing the female option on the form page
    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement femaleOption;

    // Element representing the male option on the form page
    @AndroidFindBy(xpath = "//*[@text='Male']")
    public WebElement maleOption;

    // Element representing the dropdown click option on the form page
    @AndroidFindBy(id = "android:id/text1")
    public WebElement dropDownClick;

// END

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;

	@AndroidFindBy(xpath = "//*[@text='Bangladesh']")
	public WebElement ChooseCountryBangladesh;

	public WebElement ChooseCountry(String Country) {
	return 	driver.findElement(By.xpath("//*[@text='"+Country+"']"));
	}
}