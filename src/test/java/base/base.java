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
	
	public static AndroidDriver capabilities() throws MalformedURLException
	{
		//Letting which application to run
		File f =new File("src");
		File fs = new File(f,"General-Store.apk");
		// Check if APK file exists
		if (!fs.exists()) {
			throw new RuntimeException("APK file not found at: " + fs.getAbsolutePath());
		}
		BaseOptions options = new BaseOptions()
				.amend("platformName", "Android")
				.amend("appium:automationName", "UiAutomator2")
				.amend("appium:app", fs.getAbsolutePath());
		;
		//Opening Emulator
		DesiredCapabilities  caps= new DesiredCapabilities();
		//caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("app", fs.getAbsolutePath());
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("platformVersion", "14.0");
		//Running Server in the mentioned port
		URL url = new URL("http://127.0.0.1:4723");

		AndroidDriver driver= new AndroidDriver(url,options);

		//Adding wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
}
