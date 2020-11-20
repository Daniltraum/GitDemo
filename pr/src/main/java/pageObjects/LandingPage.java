package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By navbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By headerTit=By.xpath("//div[contains(@class,'video-banner')]//p");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(signin).click(); //old return driver.findElement(signin);
		return new LoginPage(driver); // old LoginPage lp = new LoginPage(driver);
		//return lp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(headerTit);
	}
}
