package pages;


	import java.net.MalformedURLException;

	import java.util.concurrent.TimeUnit;



	import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.appiumBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
   import io.appium.java_client.MobileElement;
   import io.appium.java_client.android.AndroidDriver;

	import io.appium.java_client.android.AndroidElement;
   import io.appium.java_client.pagefactory.AndroidFindBy;



	public class mobilepage1 extends appiumBase{
	
	
	@AndroidFindBy (id="com.androidsample.generalstore:id/nameField")
	private MobileElement name;

	@AndroidFindBy(xpath=("//*[@text='Female']"))
	private MobileElement gender;  
	
	@AndroidFindBy(id="android:id/text1")
	private MobileElement locationdrop; ;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement letsshop ;
	
	@AndroidFindBy(xpath=("//android.widget.Toast[1]"))
	private  MobileElement toastMsg ;
	



	public mobilepage1(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(appiumBase.driver, this);
    } 
	
	
	    public void enterdetails() throws MalformedURLException {
	    	
	    	name.sendKeys("hello");
	    	gender.click();
	    	locationdrop.click();
	    	clickondropdown(appiumBase.driver,"Argentina");
	    	letsshop.click();
	    }
        private void clickondropdown(AndroidDriver driver,String country) {
        	 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"country\"));");
    	     driver.findElement(By.xpath("//*[@text='country']")).click();
            }
        
        


       public boolean isToastMsgDisplayed() {
    	   
      
        System.out.println(toastMsg.getAttribute("name"));
        return  toastMsg.isDisplayed();

			
		}
	}
	    

	     
	     

	     

	

	

