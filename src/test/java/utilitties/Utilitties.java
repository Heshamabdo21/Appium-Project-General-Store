
/*
 * This class is named Utilitties and is used for utility functions related to Appium testing.
 * It contains a constructor to initialize the AndroidDriver instance.
 */

package utilitties;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Utilitties {

    AndroidDriver driver;

    // Constructor to initialize the AndroidDriver instance
    public Utilitties(AndroidDriver driver) {
        this.driver = driver;
    }

    /*
     * Method scrollToText is used to scroll to a specific text on the screen.
     * It uses the AppiumBy class to locate the element by Android UIAutomator.
     */
    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

}

