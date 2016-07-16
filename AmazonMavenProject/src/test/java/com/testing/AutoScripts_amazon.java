package com.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoScripts_amazon extends ReUsableMethods_amazon{
	static WebDriver driver;
	
	//TestCase -1
	public static void launchApp() throws IOException {
		startReport("launchApp","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		launch("amazon.com");
		
		driver.close();
		bw.close();
	}
	
	//TestCase - 2
	public static void searchTextBox() throws IOException{
		startReport("searchTextBox","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement searchTB = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(searchTB,"iphone","iPhone");
	
		WebElement FirstAllDpts = driver.findElement(By.id("issDiv0"));
		elementDisplay(FirstAllDpts, "iphone 6s case in All Departments");
		
			
		WebElement secondDropdown = driver.findElement(By.id("issDiv1"));
		elementDisplay(secondDropdown, "iphone 6s case in Electronics");
		
		
		WebElement thirdDropdown = driver.findElement(By.id("issDiv2"));
		elementDisplay(thirdDropdown, "iphone 6s case in Cell Phones & Accessories");
		
		
		driver.close();
		bw.close();
		
	}
	
	//TestCase - 3
	public static void afterIphoneEntered() throws IOException{
startReport("afterIphoneEntered","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement searchTB = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(searchTB,"iphone","iPhone");
		
		WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
		elementDisplay(searchTB, "Search Button become dark");
		clickElement(searchBtn, "Search Button");
		
		WebElement pageVerify = driver.findElement(By.xpath(".//*[@id='s-result-count']/span/a"));
		pageVerify1(pageVerify, "results for iphone");
		
		driver.close();
		bw.close();
		
	}

}
