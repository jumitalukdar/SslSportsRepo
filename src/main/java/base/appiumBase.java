package base;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class appiumBase {
	
	
	
	

	public static AndroidDriver driver=null;
	
	
	public static  void init() throws MalformedURLException{	

	
		
	 File appDir = new File(System.getProperty("user.dir"));
     File app = new File(appDir, "General-Store.apk");
     DesiredCapabilities capabilities = new DesiredCapabilities();
     
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 29");
      
  //   capabilities.setCapability("avd", "jumi_emulator");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     driver = new AndroidDriver<>(new URL("http://1.0.0.1:4723/wd/hub"), capabilities);
	    

	}
	
	

}
