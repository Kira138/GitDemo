package RahulShettyUdemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import RahulShettyUdemy.pageobjects.LandingPage;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("userEmail")).sendKeys("Rahulshetty@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Password@91");
        driver.findElement(By.id("login")).click();
        Thread.sleep(8000); // Optional, just for demo purposes; consider using explicit waits instead.

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
        String productname="ZARA COAT 3";
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

      
        

       
     
   

