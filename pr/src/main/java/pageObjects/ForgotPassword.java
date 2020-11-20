package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	
	public WebDriver driver;
	//locators
	By email=By.xpath("//input[@id='user_email']");
	By sendInstract=By.xpath("//*[@type='submit']");

	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	//new method
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement sendInstract()
	{
		return driver.findElement(sendInstract);
	}
	
}
