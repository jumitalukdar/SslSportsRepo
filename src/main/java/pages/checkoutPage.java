package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.actions;

public class checkoutPage {
	@FindBy(xpath="///button[@type='submit'][contains(text(),'Continue As Guest')]")
	WebElement asGuest;
	@FindBy(xpath="//input[@name='guestEmail']")
	WebElement guestemail;
	actions action;

	public checkoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		action=new actions();
	}
	
	public void checkout () {
		
		action.enterText(asGuest, constants.email);
		action.clickon(asGuest);
	}
	

}
