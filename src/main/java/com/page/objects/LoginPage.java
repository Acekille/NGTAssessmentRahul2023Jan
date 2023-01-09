package com.page.objects;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LoginPage {
	public static void LaunchMyApp(WebDriver driver) {
		driver.get("https://www.myntra.com/login/password");
	}
	public static void EnterCredentials(WebDriver driver) throws Exception {
		Properties propObj = new Properties();
		propObj.load(new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//credentials.properties"));
		
		String Email = propObj.getProperty("Email");
		String Password = propObj.getProperty("Password");
		driver.findElement(By.xpath("//*[@id=\"mobileNumberPass\"]")).sendKeys(Email);
		driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input")).sendKeys(Password);
		
		driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
		Thread.sleep(32000);
		driver.findElement(By.xpath("//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")).click();
		
	
		
			
	}
}
