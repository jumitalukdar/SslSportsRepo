package base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import pages.constants;
public class Baseclass {
	
	public static WebDriver driver =null;
	
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;
	
	public static void initialize()
	{
		if (driver==null)
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user")+ "/Drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhij\\Desktop\\Jumi\\chromedriver_win\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--disable-popup-blocking");
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
			DesiredCapabilities cap= DesiredCapabilities.chrome();
			options.merge(cap); 
			driver=new ChromeDriver(options);
			
		}
		
		
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(constants.url);
	}
	    
	
	public String takScreenshot(WebDriver driver)
	
	{
	if(driver==null)
	{
		System.out.println("driver null");
		return null;
	}
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File des=new File(System.getProperty("user")+ "/screenshot"+".png");
	try {
		Files.copy(src, des);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return des.toString();
		
	}
	
	//public void setExtent()
	//{
		 
	//	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");  
	//	  htmlReporter.config().setDocumentTitle("Automation report");
	//	  htmlReporter.config().setReportName("functional report");
	//	  htmlReporter.config().setTheme(Theme.DARK);
		  
	//	  extent = new ExtentReports();
	//	  extent.attachReporter(htmlReporter);
		  
	//	  // Passing General information
	//	  extent.setSystemInfo("Host name", "localhost");
	//	  extent.setSystemInfo("Environemnt", "QA");
	//	  extent.setSystemInfo("user", "pavan");
	//	 }
	
	//public void endReport() {
	//	  extent.flush();
	//	 }
		  
	
	
	public static void quitdriver()
	
	{
		
		driver.quit();
		driver=null;
	}   

}
