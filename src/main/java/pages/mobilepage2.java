package pages;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.appiumBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class mobilepage2 extends appiumBase{




	public mobilepage2(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(appiumBase.driver, this);
    }
    @AndroidFindBy(className = "UIAKeyboard")
    private MobileElement keyboard;
    @AndroidFindBy(id= "com.androidsample.generalstore:id/productAddCart")
    private List<MobileElement> addTocart;
    @AndroidFindBy(id="com.androidsample.generalstore:id/productName")
    private List<MobileElement> productlist;
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private MobileElement viewCart;
    
    public void SelectProductByScrolling(String text)
    
    {
    	  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(text).instance(0))"));
    	  int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	   
   	     
   	     for(int i=0;i<count;i++)

    	    {

    	    String text1=productlist.get(i).getText();

    	   

    	    if(text1.equalsIgnoreCase("text"))

    	    {   	   

    	      addTocart.get(i).click();

    	     break;

    	    }	  	   

    	    }    	   

    	   viewCart.click(); 	  
  	  	        

    	}

    	}



    
   