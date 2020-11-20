package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	//LandingPage land;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	@Test
	
	public void validateHomeTitle() throws IOException
	{

		//two ways if obtaining files . 1 is inheritance. 2 is creating object to that class and invoke methids
		LandingPage land=new LandingPage(driver);
		log.info("Verifiing text merssage");
		//compare the text from the browser with actual value, if there is a mismatch - print error
		Assert.assertEquals(land.getTitle().getText(), "FEATURED 12COURSESsd");
		log.info("Succeddfuly validates text message");

	}
	
	@Test
	
	public void validateHomeTitleTwo() throws IOException
	{


        log.info("User 2 added more changes");
		//two ways if obtaining files . 1 is inheritance. 2 is creating object to that class and invoke methids
		LandingPage land=new LandingPage(driver);
		log.info("Verifiing text merssage");
		//compare the text from the browser with actual value, if there is a mismatch - print error
		Assert.assertEquals(land.getTitle().getText(), "FEATURED 12COURSESsd");
		log.info("Succeddfuly validates text message");

	}
	
	

	@Test
	
	public void validateHomeHeader() throws IOException
	{
	
	
	
	//div[contains(@class,'video-banner')]//p
		log.info("CHwcing sesond obe");
		//two ways if obtaining files . 1 is inheritance. 2 is creating object to that class and invoke methids
		LandingPage land=new LandingPage(driver);
		//compare the text from the browser with actual value, if there is a mismatch - print error
	log.info(land.getHeader().getText()+" 1");
	System.out.println(land.getHeader().getText()+" 2");
		//Assert.assertEquals(land.getHeader().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Succeddfuly validated header text");

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
