package RahulShettyUdemy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyUdemy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent    //pageobject should not hold any data this should focus only on elements and actions
{	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement email=driver.findElement(By.id("userEmail"));
	//WebElement password=driver.findElement(By.id("userPassword"));
	// WebElement submit=driver.findElement(By.id("login"));
	
	//pagefactory
	@FindBy(id="userEmail")//driver.findElement(By.id("userEmail"));
	WebElement email;	 //WebElement email
	
	@FindBy(id="userPassword") //driver.findElement(By.id("userPassword"));
	WebElement password;   //WebElement password
	
	@FindBy(id="login") //driver.findElement(By.id("login"));
	WebElement submit;  // WebElement submit
	
	public void LoginApplication(String useremailid,String userpassword) //data should be sent by test cases and we are not hard coding it
	{
		email.sendKeys(useremailid);
		password.sendKeys(userpassword);
		submit.click();
	}
	public void goTo()
	
	{
		  driver.get("https://rahulshettyacademy.com/client");
	}
}
