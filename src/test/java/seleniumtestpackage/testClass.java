package seleniumtestpackage;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.ContinueGuestPage;
import pages.constants;
import pages.homepage;
import pages.productList;
import pages.secureCheckoutPage;

public class testClass {
homepage home;
productList plist;
secureCheckoutPage securechkpage;
ContinueGuestPage guestpage;
	
@BeforeClass
public void setUp()
{

    Baseclass.initialize();
    

	
}

@Test(priority=1)
public void validatehomepage()
{
	String expTitle= "Mens Fashion & Sportswear Online in Dubai, Abu Dhabi, UAE | SSS";
	home=new homepage(Baseclass.driver);
	home.clickonMenMenu();
//	home.clickonpop();
	home.clickonshopAll(Baseclass.driver);
//	home.clickonpop();
	System.out.println(Baseclass.driver.getTitle());
	Assert.assertEquals(expTitle,Baseclass.driver.getTitle());
	
	
	
}

@Test(priority=2)
public void validateaddtoCart()
{
	
	plist=new productList(Baseclass.driver);
	
	plist.performaddtocart();
	
	//Assert.assertTrue(plist.performaddtocart());
	plist.clickonCheckout();
	
	
	
}
	

@Test(priority=3)
public void validateguestlogin()
{
	String expTitle="Sites-UAE-Site";
	guestpage=new ContinueGuestPage(Baseclass.driver);
	guestpage.clickoncontAsGuest();
	Assert.assertEquals(expTitle,Baseclass.driver.getTitle());
	
	
}
	
@Test(priority=4)
public void validatasecurechkout()
{
	securechkpage=new secureCheckoutPage(Baseclass.driver);
	securechkpage.enterContactDetails(constants.salut,constants.fname,constants.lname);
	securechkpage.scrolldown(Baseclass.driver);
	securechkpage.clickonpopup(Baseclass.driver);
	securechkpage.enterShippingAdress(constants.address1, constants.region, constants.area);
	Assert.assertEquals(securechkpage.validateRegionselected(),constants.region);
	Assert.assertEquals(securechkpage.validateAreaselected(),constants.area);
}
	


@AfterClass
public void teardown()
{
	System.out.println("clossing");
	//Baseclass.quitdriver();
}
}
