package commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;
import base.appiumBase;
import io.appium.java_client.MobileElement;
import pages.constants;

public class actions {
	public static WebDriverWait wait;

	
	public static void clickon(WebElement element) {
		element.click();
		
	}
	
	public static String getText(WebElement element)
	
	{
		return element.getText();
	}
	

	public static void selectdropdown(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void isdropdownselected(WebElement element, String text)
	{
		Select select=new Select(element);
		select.getFirstSelectedOption();
		return ;
	}

	
	
	public static void enterText(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	
	public static void switchToFrame(WebElement element,WebDriver driver) {
		wait=new WebDriverWait(Baseclass.driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		Baseclass.driver.switchTo().frame(element);
	}
	public static void switchToMainWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static boolean jsClick(WebElement element, WebDriver driver){
		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			return true;
		}catch(Exception e){
			System.out.println("Unable to click element " +element);
			return false;
		}	
	}
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean explicitWaitForClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

