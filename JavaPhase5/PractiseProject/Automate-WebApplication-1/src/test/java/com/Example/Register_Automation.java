package com.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register_Automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver/chromedriver.exe");
		  
	        WebDriver driver = new ChromeDriver();
	        
	        driver.get("https://www.shine.com/myshine/login/");
	        

			 //login email
			 WebElement Email=driver.findElement(By.id("id_email_login"));
			 Email.sendKeys("varshinisolachana@gmail.com");
			 
			//password
			WebElement Password=driver.findElement(By.id("id_password"));
			Password.sendKeys("Varsh@12345");
			
			//button
			WebElement Login=driver.findElement(By.xpath("//*[@id=\"cndidate_login_widget\"]/form/ul[2]/li[4]/div/button"));
			Login.click();
			
}
	

}
