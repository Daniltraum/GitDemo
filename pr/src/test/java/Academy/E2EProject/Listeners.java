package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportedNG;
import resources.base;

public class Listeners extends base implements ITestListener {

	ExtentTest test;
	
	ExtentReports extent = ExtentReportedNG.getReportObject();
	ThreadLocal<ExtentTest> extentParal = new ThreadLocal<ExtentTest>();// to be able to run all the test paralelly, add this line
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentParal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentParal.get().log(Status.PASS, "Pass"); // old test.log(Status.PASS, "Pass"); withiut parallel
	}

	@Override
	public void onTestFailure(ITestResult result)  
	{
			// TODO Auto-generated method stub
		extentParal.get().fail(result.getThrowable());//to see all falure logs use getthrowable
			WebDriver driver = null;
			String testMethodName=result.getMethod().getMethodName();
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e)
			{}
			try {
				//adding ascreenshot
				extentParal.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
				//getScreenShotPath(testMethodName, driver); - removing if i Don't want to save the screenshots in resources folder
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		
		}
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
