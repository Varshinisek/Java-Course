package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Automation {
	
	@Test(priority = 1)
	  public void register() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver/chromedriver.exe");
	      WebDriver wd = new ChromeDriver();
		 
	      wd.manage().window().maximize();
	      wd.get("https://www.amazon.in/");
	      wd.findElement(By.id("nav-link-accountList")).click();
	      wd.findElement(By.id("createAccountSubmit")).click();
	      wd.findElement(By.id("ap_customer_name")).sendKeys("Varsh");
	      //wd.findElement(By.id("ap_phone_number")).sendKeys("1234567890");
	      wd.findElement(By.id("ap_email")).sendKeys("varsh@gmail.com");
	      wd.findElement(By.id("ap_password")).sendKeys("1234567");
	      wd.findElement(By.id("ap_password_check")).sendKeys("1234567");
	    // wd.findElement(By.id("continue")).click();

	     
	  }
	@Test(priority = 2)
	  public void login() {
		  
	      WebDriver wd=new ChromeDriver();
	      wd.manage().window().maximize();
	      wd.get("https://www.amazon.in/");
	      wd.findElement(By.id("nav-link-accountList")).click();
	      wd.findElement(By.id("ap_email")).sendKeys("varsh@gmail.com");
		  wd.findElement(By.id("continue")).click();
	      wd.findElement(By.id("ap_password")).sendKeys("1234567");


	  }
	  @Test(priority = 3)
	  public void addToCart() throws InterruptedException {
		  	WebDriver wd=new ChromeDriver();
	      	wd.get("https://www.amazon.in/");
		    System.out.println(wd.getTitle());
		    System.out.println(wd.getCurrentUrl());
		    wd.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlus mobiles");
		    Thread.sleep(5000);
		    wd.findElement(By.id("nav-search-submit-button")).submit();
		    wd.findElement(By.linkText("OnePlus Nord 2T 5G (Gray Shadow, 8GB RAM, 128GB Storage)")).click();
	        wd.findElement(By.id("add-to-cart-button")).click();
	  }

}
