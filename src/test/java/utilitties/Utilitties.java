/*
 * Copyright (c) 2024.
 */

package utilitties;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Utilitties {

	AndroidDriver driver;

	public Utilitties(AndroidDriver driver) {
		this.driver = driver;
	}

	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}

}
