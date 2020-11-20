package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		
	}
	@Test(dataProvider="getData")
	
	public void basePageNavig(String Username, String Password, String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		//two ways if obtaining files . 1 is inheritance. 2 is creating object to that class and invoke methids
		LandingPage land=new LandingPage(driver);
		LoginPage lp = land.getLogin();
	//	LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		
		//System.out.println(text);
		log.info(text);
		lp.getLogin().click();
		ForgotPassword fp=lp.fogrotPass();
		fp.getEmail().sendKeys("xxd@gmail.com");
		fp.sendInstract().click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Adding new code for USer 2 git test");
		log.info("GIt ptoject testing");
	}

	@DataProvider
	private Object[][] getData() {
		//row stands for how many diffrent data types
		//column stands for how many valeus
		// array size is 5 means 0,1,2,3,4
		//0th row
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestrict@gmail.com";
		data[0][1]="123456";
		data[0][2]="Non-restricted user";
		//1st row
		data[1][0]="restrict@gmail.com";
		data[1][1]="876543";
		data[1][2]="Restricted user";
		
		return data;
		
	}
	
	/*@AfterTest
	public void teardown()
	{
		driver.close();
	}*/ // moving up in order to open page twice properly

}
