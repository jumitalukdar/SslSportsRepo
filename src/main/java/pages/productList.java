package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Baseclass;
import commons.actions;

public class productList {
	 actions common;

	@FindBy(xpath="//img[@src='https://en-ae.sssports.com/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw023e1163/sss/N/K/C/NKCV0978_107_194956610281_2.jpg?sw=400&sh=400&sm=fit']")
	WebElement itemimage;
	
	@FindBy(xpath="//div[@class='container cart']//div[@class='line-item-name']/span")
	WebElement itemaddedincart;
	@FindBy(xpath="//span[@id='select2-vendorSize-shoesize-container']")	
	
	WebElement selectsizeLabel;
	@FindBy(xpath="//ul[@id='select2-vendorSize-shoesize-results']//li[contains(text(), 'EU 40.5')]")
		
	WebElement sizefigure;
	@FindBy(xpath="//button[text()='Add to bag']")
	WebElement addTobag;
	
	@FindBy(xpath="//div[@class='card-body']//div[@class='line-item-name']/span]")
	WebElement itemvisibleinCart;
//	@FindBy(xpath="//a[@class='btn btn-secondary btn-block checkout-btn']")
	@FindBy(xpath="//div[@class='row checkout-buttons']//a[@data-gtm-click='checkoutSecurely']")
	WebElement checkout;
	@FindBy(xpath="//div[@class='roduct-grid js-product-grid']//div[@class='product']")
	WebElement productlist;
	@FindBy(xpath="//iframe[@id='preview-notification-frame']")
	WebElement frame;
	@FindBy(xpath="//div[@id='NC_background_image']//a[@id='NC_CLOSE_ICON']")
	WebElement randompop;
	@FindBy(xpath="//button[@class='affirm btn btn-primary btn--affirm js-consent-submit']")
	WebElement iagree;
	actions action;
	public productList(WebDriver driver)
	{
		PageFactory.initElements(Baseclass.driver,this);
		 action=new actions();
	}
	
	public boolean performaddtocart()
	
	{ 
	  Baseclass.driver.switchTo().frame(frame);
	  action.clickon(randompop);
	  String itemadded=action.getText(itemimage);
	  System.out.println(itemadded);
	  action.clickon(itemimage);
	  action.clickon(iagree);
	  System.out.println("agree clicked");
	  
	  clickonsize();
	  System.out.println("addTocart.isdisplayed");
	 action.clickon(addTobag);
	 
	  String itemincart=action.getText(itemaddedincart);
	  System.out.println(itemadded);

  	if(itemadded.equalsIgnoreCase(itemincart))
	{
		return true;
	}
	return false;
	  
		
	}
	
//*	public boolean isproductaddedinThecart(String itemadded)
//	{
//		  System.out.println("enetring");
//		 
//		  System.out.println("enetring2");
//		  String itemincart=itemaddedincart.getText();
//		  System.out.println(itemadded);
//		  System.out.println(itemincart);
//		  
		  
//	    	if(itemadded.equalsIgnoreCase(itemincart))
//		{
//			return true;
//		}
//		
//		return false;
		
//	}
	
	
public void clickonsize()
	
	{
	System.out.println(selectsizeLabel.isDisplayed());
	actions.clickon(selectsizeLabel);
	actions.clickon(sizefigure);
//	JavascriptExecutor ex = (JavascriptExecutor)Baseclass.driver;
//	ex.executeScript("arguments[0].click();", sizelabel);
//	System.out.println("sizelabel clicked");
	//ex.executeScript("arguments[0].click();", size);
	System.out.println("size selected");
	
	}

public ContinueGuestPage clickonCheckout()

{
	action.clickon(checkout);
	return new ContinueGuestPage(Baseclass.driver);
}


		
	

}
