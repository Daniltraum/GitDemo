package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportedNG {

	static ExtentReports extent; // adding extent globally
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Daniel Results");
		
		extent = new ExtentReports(); // no need for "ExtentReports extent = new bla bla bla, since declared globally
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Daniel W");
		return extent;
	}
}
