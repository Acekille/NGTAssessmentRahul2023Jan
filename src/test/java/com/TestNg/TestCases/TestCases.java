package com.TestNg.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.objects.*;

public class TestCases {
	public static WebDriver driver = null;
	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(enabled=false)
	public void LoginTest() throws Exception{
		LoginPage.LaunchMyApp(driver);
		LoginPage.EnterCredentials(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[1]/span[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[2]/div[2]/div[1]/a/div[1]"));

		actions.moveToElement(subMenu);		
		actions.click().build().perform();
		String result =driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div/div[3]/div/table/tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(result, "rahul chauhan");
	}
	@Test
	public void AddItemTest() throws Exception {
		LoginPage.LaunchMyApp(driver);
		LoginPage.EnterCredentials(driver);
		BagPage.BagButtonClick(driver);
	 BagPage.AddItem(driver);
		BagPage.BagButtonClick(driver);
		String productInBage = driver.findElement(By.xpath("//*[@id=\"cartItemsList\"]/div/div/div/div[2]/div[2]/div/div[1]/div")).getText();
		Assert.assertEquals("Bewakoof", productInBage);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
