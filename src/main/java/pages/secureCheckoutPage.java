package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Baseclass;
import commons.actions;

public class secureCheckoutPage {
	
	//@FindBy(xpath="//div[@data-gtm-event-label='Salutation']")
	@FindBy(xpath="//select[@id='shippingSalutationdefault']")
    WebElement titleDropdown;
	@FindBy(xpath="//input[@id='shippingFirstNamedefault']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='shippingAddressOnedefault']")
	WebElement addressLine1;
	@FindBy(xpath="//select[@id='shippingAreadefault']")
	WebElement areaDropdown;
	
	@FindBy(xpath="//select[@id='shippingCitydefault']")
	WebElement regionDropdown;
	@FindBy(xpath="//input[@id='shippingLastNamedefault']")
	WebElement lastName;
	@FindBy(xpath="//iframe[@class='__st_preview_frame_bpn']")
	WebElement frame;
	@FindBy(xpath="//input[@value='Block']")
	WebElement popup;
	
    public actions action;
	public secureCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(Baseclass.driver,this);
		action=new actions();
	}
	
	public void selectTitle(String title)
	{
		Select select=new Select(titleDropdown);
		select.selectByVisibleText(title);
		
		
	}
	public void selectRegion(String Region)
	{
		Select select=new Select(regionDropdown);
		 select.selectByVisibleText(Region);
		//  select.selectByValue(Region);
		//select.getOptions().get(0).click();
		
		
		
		
	}
	
	public void selectArea(String area)
	{
		Select select=new Select(areaDropdown);
	    select.selectByVisibleText(area);
	//	select.getOptions().get(0).click();
		
		
	}
	
	
	
	
	public void enterContactDetails(String salut,String fname,String lname)
	{
		
		selectTitle(salut);

		action.enterText(firstname, fname);
		action.enterText(lastName, lname);
		
		
		
	}

	public void enterShippingAdress(String address1,String region,String area) {
        action.enterText(addressLine1, address1);
		//addressLine1.sendKeys(address1);
		selectRegion(region);
		selectArea(area);
	}

	public void scrolldown(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor)Baseclass.driver;
		js.executeScript("window.scrollBy(0,1000)");
}
	
	public String validateRegionselected() {
		
		Select select=new Select(regionDropdown);
		System.out.println("text is"+ select.getFirstSelectedOption().getText());
		String text=select.getFirstSelectedOption().getText();
		return text;
	}
	

	public String validateAreaselected() {
		
		Select select=new Select(areaDropdown);
		System.out.println("text is"+ select.getFirstSelectedOption().getText());
		String text=select.getFirstSelectedOption().getText();
		return text;
	}
	public void clickonpopup(WebDriver driver)
	
	{
		action.switchToFrame(frame, driver);;
		popup.click();
	}
}
