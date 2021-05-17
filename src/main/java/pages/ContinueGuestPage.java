package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Baseclass;
import commons.actions;

public class ContinueGuestPage {
	actions action;
	
	@FindBy(xpath="//input[@name='guestEmail']")
    WebElement email;
	
	@FindBy(xpath="//button[contains(text(),'Continue As Guest')]")
	WebElement guestButton;
	public ContinueGuestPage(WebDriver driver) {
		PageFactory.initElements(Baseclass.driver,this);
		action=new actions();
	}
	public secureCheckoutPage clickoncontAsGuest() 
	{    actions.enterText(email, constants.email);
		
		action.clickon(guestButton);
		return new secureCheckoutPage(Baseclass.driver); 
	}
	
	
}
