package com.testing;

import java.io.IOException;
import java.util.List;
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
		
		WebElement pageVerify = driver.findElement(By.xpath(".//*[@id='bcKwText']/span"));
		pageVerify1(pageVerify, "results for iphone");
		
		driver.close();
		bw.close();
		
	}
	
	//TestCase -4
	public static void cellPhoneAndAccessories() throws IOException{
		startReport("cellPhoneAndAccessories","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement cellPneAce = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[2]/strong"));
		elementDisplay(cellPneAce, "CellPhones & Accessories");
	
		WebElement cellPneCases = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[5]/a/span[1]"));
		elementDisplay(cellPneCases, "Cell Phones Cases");
		
		WebElement replacementParts = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[6]/a/span[1]"));
		elementDisplay(replacementParts, "Replacement Parts");
		
		WebElement seeMore = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']"));
		elementDisplay(seeMore, " + SeeMore");
		
		driver.close();
		bw.close();
	}
	
	//TestCase5
	public static void computerAccessoriesAndHeader() throws IOException{
		
startReport("computerAccessoriesAndHeader","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		WebElement computerComponents = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a/span"));
		elementDisplay( computerComponents, "Computer Components");
		clickElement(computerComponents, "Computer Components");
	
		WebElement pageVerify = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[4]/strong"));
		pageVerify1(pageVerify, "Computer Components");
		
		driver.close();
		bw.close();
	
	}
	
	//TestCase6
	public static void electronicsHeader() throws IOException{
		
		startReport("electronicsHeader","c:/Users/KOMMURI/Documents/canvas/Report");
				
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.amazon.com/s/ref=nb_sb_ss_c_2_3?url=search-alias%3Delectronics&field-keywords=iphone+6s+case&sprefix=undefined%2Caps%2C234");
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				WebElement electronics = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[2]/strong"));
				elementDisplay(electronics, "Electronics");
				
				WebElement screenProtectors = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[12]/a/span[1]"));
				elementDisplay(screenProtectors, "Screen Protectors");
				
				WebElement phoneCharms = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[11]/a/span[2]"));
				elementDisplay(phoneCharms, "Phone Charms");
	
				WebElement seeMore= driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
				elementDisplay(seeMore, "See More");
				
				driver.close();
				bw.close();
	}
	
	
	//TestCase7
	public static void leftColumOptions() throws IOException{
		startReport("leftColumOptions","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement amazonPrime = driver.findElement(By.xpath(".//*[@id='refinements']/h2[1]"));
		elementDisplay(amazonPrime, "Amazon Prime");
		
		WebElement elegibleForFreeShipping = driver.findElement(By.xpath(".//*[@id='refinements']/h2[2]"));
		elementDisplay(elegibleForFreeShipping, "Elegible ForFree Shipping");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement customerReview = driver.findElement(By.xpath(".//*[@id='refinements']/h2[3]"));
		elementDisplay(customerReview, "Avg. Customer Review");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		WebElement brand = driver.findElement(By.xpath(".//*[@id='refinements']/h2[4]"));
		elementDisplay(brand, "Brand");
	
		WebElement apple = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[1"));
		elementDisplay(apple, "Apple");
	
		WebElement hyperion = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[2]/a/span"));
		elementDisplay(hyperion, "Hyperion EA");
	
		WebElement rinbers = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[3]/a/span"));
		elementDisplay(rinbers, "Rinbers");
	
		WebElement grantWood= driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[5]/a/span"));
		elementDisplay(grantWood, "Grant Wood Technology");
	
	driver.close();
	bw.close();
	
	
	}
	
	//TestCase 8
	public static void listInMainTab() throws IOException{
		startReport("listInMainTab","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		launch("amazon.com");
		
		WebElement shopByDpt = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		tabDropdownMenu(shopByDpt, "DepartMent");
		
		WebElement youamnLink = driver.findElement(By.xpath(".//*[@id='nav-your-amazon']"));
		elementLink(youamnLink, "YourAmanon.com link ");
		
		
		WebElement todayDeals = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]"));
		elementLink(todayDeals, "ToDays's Deals link");
		
		WebElement giftCards = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]"));
		elementLink(todayDeals, "ToDays's Deals link");
		
		WebElement sellLink = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[4]"));
		elementLink(sellLink,"Sell link");
		
		WebElement helpLink = driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
		elementLink(helpLink, "Help Link");
		
		WebElement helloSignInAct = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[2]"));
		elementLink(helloSignInAct, "Hello.sign in Your Account link");
		
		WebElement tryPrime = driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
		elementLink(tryPrime, "Try Prime link");
		
		WebElement yourList = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']/span[2]"));
		elementLink(yourList,"List");
		
		WebElement cart = driver.findElement(By.xpath(".//*[@id='nav-cart']/span[2]"));
		elementLink(cart, "Cart");
		
		driver.close();
		bw.close();
		
	}
	
	//TestCase 9
	
	public static void departmentDropdown() throws IOException{
		startReport("departmentDropdown","c:/Users/KOMMURI/Documents/canvas/Report");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		launch("amazon.com");
		
		WebElement department = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		tabDropdownMenu(department, "DepartMent");
		
	
		List<WebElement> departmentDropDownlist = driver.findElements(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
		for(WebElement option : departmentDropDownlist){
			option.getText();
		}
		
		tabDropdownMenu(department, "DepartMentdropdownList");
		
		bw.close();
	}
	
	
}
