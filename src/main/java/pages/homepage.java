package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Baseclass;
import commons.actions;

public class homepage {
	
	actions common;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav d-lg-flex justify-content-lg-center']//li/a[text()='Men']")
    WebElement MenuMen;
	

	@FindBy(xpath="//div[@class='hero-banner__buttons']//a[contains(text(),'Shop All')]")
    WebElement shopAll;
	@FindBy(xpath="//div[@id='NC_background_image']//a[@id='NC_CLOSE_ICON']")
	WebElement randompop;
	//FindBy(xpath="//div[@class=\"product-grid js-product-grid\"]//div[@class=\"product\"]")
	//WebElement productlist;
	@FindBy(xpath="//iframe[@id='preview-notification-frame]")
	WebElement frame;
	
	public homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		actions common=new actions();
	}
	
	public void clickonpop() {
		Baseclass.driver.switchTo().frame(frame);
		actions.clickon(randompop);
		System.out.println("pop up closed");
	}
	public void clickonMenMenu()
	
	{ 
		actions.clickon(MenuMen);
		System.out.println("men menu clicked");
		
	}
	
    public productList clickonshopAll(WebDriver driver)
	
	{
    	actions.clickon(shopAll);
    	System.out.println("shopall menu clicked");
    	return new productList(driver);
		
	}
}