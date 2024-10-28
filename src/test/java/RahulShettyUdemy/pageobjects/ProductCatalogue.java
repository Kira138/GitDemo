package RahulShettyUdemy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyUdemy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {    //pageobject should not hold any data this should focus only on elements and actions
	
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//pagefactory
	@FindBy(css=".mb-3") //driver.findElements(By.cssSelector(".mb-3"));
	List<WebElement> products;	 //List<WebElement> products
	
	By productsBy=By.cssSelector(".mb-3");
	
	public List<WebElement>getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

}