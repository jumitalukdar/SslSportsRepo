package extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.constants;




 
public class ExtentReportNG {
	
	static ExtentReports extent;

	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+
				"/test-output/ExecutionReport_"+actualDate+".html";
		
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
		
		 extent = new ExtentReports();
		 extent.attachReporter(htmlReport);
		
		htmlReport.config().setDocumentTitle("DocumentTitle");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("ReportName");
		
		
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

		return extent;
	}


}