package com.page.objects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BagPage {
	public static void BagButtonClick(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[3]")).click();
	}
	public static void AddItem(WebDriver driver) {
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys("Redmi 10");
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[3]/a/div[1]/div/div/div/picture/img")).click();
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> I1= allWindows.iterator();
		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!mainWindow.equals(child_window))
		{
		driver.switchTo().window(child_window);

		
		}}
		
		
		driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")).click();

	}
}
