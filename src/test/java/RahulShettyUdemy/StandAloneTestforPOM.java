package RahulShettyUdemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RahulShettyUdemy.pageobjects.LandingPage;

public class StandAloneTestforPOM {


		public static void main(String[] args) throws InterruptedException {
			
			String productname="ZARA COAT 3";
	        WebDriver driver = new ChromeDriver();
	      
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	       /* driver.findElement(By.id("userEmail")).sendKeys("Rahulshetty@gmail.com");
	        driver.findElement(By.id("userPassword")).sendKeys("Password@91");
	        driver.findElement(By.id("login")).click();
	        Thread.sleep(8000); // Optional, just for demo purposes; consider using explicit waits instead.*/
	        
	        LandingPage landingpage=new LandingPage(driver);
	        landingpage.goTo();
	        landingpage.LoginApplication("Rahulshetty@gmail.com", "Password@91");

	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	        
	        WebElement prod=products.stream().filter(product->
	        product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);

	             prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

	                 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	               wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	              wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	                   driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	                   
	                 List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	                Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
	                Assert.assertTrue(match);
	                driver.findElement(By.cssSelector(".totalRow button")).click();
	               Actions a=new Actions(driver);
	               a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	               wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	               
	               driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	               driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	               
	               String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	               Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	               driver.close();
	    }
	}

	      
	        

	       
	     
	   

