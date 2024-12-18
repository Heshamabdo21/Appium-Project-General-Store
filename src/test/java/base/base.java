
/*
 * This class serves as the base class for the test automation framework.
 * It includes methods for setting up the Appium driver capabilities.
 */

package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.options.BaseOptions;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class base {

    public static AndroidDriver driver;
    
    // BEGIN
        // Method to set up the capabilities for the Appium driver
        public static AndroidDriver capabilities() throws MalformedURLException
        {
            // Letting which application to run
            File f = new File("src"); // Creating a new File object with the directory path "src"
            File fs = new File(f, "General-Store.apk"); // Creating a new File object with the directory path "src" and file name "General-Store.apk"
            
            // Check if APK file exists
            if (!fs.exists()) { // Checking if the APK file exists
                throw new RuntimeException("APK file not found at: " + fs.getAbsolutePath()); // Throwing a runtime exception if the APK file is not found
            }
            
            // Setting up BaseOptions for the driver
            BaseOptions options = new BaseOptions() // Creating a new BaseOptions object
                    .amend("platformName", "Android") // Setting the platformName capability to "Android"
                    .amend("appium:automationName", "UiAutomator2") // Setting the automationName capability to "UiAutomator2"
                    .amend("appium:app", fs.getAbsolutePath()); // Setting the app capability to the absolute path of the APK file
            
            // Opening Emulator
            DesiredCapabilities caps = new DesiredCapabilities(); // Creating a new DesiredCapabilities object
    		//caps.setCapability("deviceName", "emulator-5554"); // Setting the deviceName capability
    		caps.setCapability("app", fs.getAbsolutePath()); // Setting the app capability to the absolute path of the APK file
    		caps.setCapability("platformName", "Android"); // Setting the platformName capability to "Android"
        // Setting the capability "automationName" to "UiAutomator2"
        caps.setCapability("automationName", "UiAutomator2");
        // Setting the capability "platformVersion" to "14.0"
        caps.setCapability("platformVersion", "14.0");
        // Creating a URL object with the server address "http://127.0.0.1:4723"
        URL url = new URL("http://127.0.0.1:4723");

        // Initializing an AndroidDriver with the server URL and options
        AndroidDriver driver= new AndroidDriver(url,options);

        // Setting an implicit wait time of 10 seconds for the driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Returning the initialized AndroidDriver
        return driver;
}
