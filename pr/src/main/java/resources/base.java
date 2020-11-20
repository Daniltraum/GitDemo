package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	
	public WebDriver driver; // access to this object will be available to entire java test case
	public Properties prop;
	public String dirPath=System.getProperty("user.dir");
	public WebDriver initializeDriver() throws IOException
	{
		//chrome
		
		//firefox
		
		//IE
		
	prop = new Properties();
	
	FileInputStream fis = new FileInputStream(dirPath+"\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fis);
	
	//String browserName=System.getProperty("browser");
	String browsName=prop.getProperty("browser");
	String url=prop.getProperty("url");
	System.out.println(browsName);
	if(browsName.contains("chrome"))
	{
		//execute in chrome
		System.setProperty("webdriver.chrome.driver", dirPath+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		if(browsName.contains("headless"))
		{
			co.addArguments("headless");
		}
		
		driver = new ChromeDriver(co);
	}
	else if (browsName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", dirPath+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver= new FirefoxDriver();
	}
	
	else if (browsName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", dirPath+"\\src\\main\\java\\resources\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //applies to all test cases in framework
	return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		//Screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destFile = dirPath+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
		
	}
}
