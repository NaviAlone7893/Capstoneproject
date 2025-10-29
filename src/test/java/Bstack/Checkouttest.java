package Bstack;

import org.testng.annotations.Test;

import com.reusablePages.Cartpage;
import com.reusablePages.Checkoutpage;
import com.reusablePages.Loginpage;
import com.reusablePages.Productpage;

import utility.Webdriver;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Checkouttest {
	WebDriver driver;
	Loginpage l;
	Cartpage c;
	Checkoutpage checkout;
	Productpage pr;
	Webdriver w;
	JavascriptExecutor js;
	
	@BeforeTest
	  public void launch() {
		  w = new Webdriver();
	      driver = w.launchbrowser("https://bstackdemo.com/");
	      l = new Loginpage(driver);
	      c= new Cartpage(driver);
	      checkout = new Checkoutpage(driver); 
	      pr = new Productpage(driver);// initialize here

	      js = (JavascriptExecutor) driver;
	  }
 
	 @Test(priority = 1)
	  public void login() throws InterruptedException {
		 l.logincred("demouser", "testingisfun99");
		  
		  
	 }
	 @Test(priority = 2)
	  public void productsearch() throws InterruptedException {
		 pr.product("iphone 12");
		  
	  }
	 @Test(priority = 3)
	  public void addtocart() {

		 c.addingMultiple();

     }
	 @Test(priority = 4)
	  public void checkout() throws InterruptedException {
			js.executeScript("window.scrollBy(0,200)");

		 checkout.checkout("john", "doe", "Hyderabad", "500001", "Telangana");
	 }
		  
	 @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
