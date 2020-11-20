package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavbar extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	@Test
	
	public void validateAppNavBar() throws IOException
	{
		
		//two ways if obtaining files . 1 is inheritance. 2 is creating object to that class and invoke methids
		LandingPage land=new LandingPage(driver);
		
		Assert.assertTrue(land.getNavbar().isDisplayed());
		log.info("Validated if menu bar is present");
		
		log.info("And some more changes By user 1 for Git test");
	}
	
	@Test
	
	public void validateAppNavBarOne() throws IOException
	{
		log.info("User 1 - America adding new test case for git");
		//two ways if obtaining files . 1 is inheritance. 2 is creating object to that class and invoke methids
		LandingPage land=new LandingPage(driver);
		
		Assert.assertTrue(land.getNavbar().isDisplayed());
		log.info("Validated if menu bar is present");
		
		log.info("And some more changes By user 1 for Git test");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
