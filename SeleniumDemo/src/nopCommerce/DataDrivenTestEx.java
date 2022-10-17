package nopCommerce;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

public class DataDrivenTestEx {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	WebDriver driver;
	
	
	@BeforeClass
	public void testOpenBrowser()
	{
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Logincredentials")
	public void testLoging(String UnserName, String Password, String ExpResult) 
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement untext = driver.findElement(By.xpath("//input[@id='Email']"));
		untext.clear();
		untext.sendKeys(UnserName);
		
		WebElement pwdTex = driver.findElement(By.xpath("//input[@id='Password']"));
		pwdTex.clear();
		pwdTex.sendKeys(Password);
		
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		String ExpectedTile ="Dashboard / nopCommerce administration";
		String actual_Title= driver.getTitle();	}
	
	@AfterClass
	public void TestLogout()
	{
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	
	@DataProvider(name="Logincredentials")
	public Object[][] getdata()
	{
		Object logindata  [] [] = {
				{"admin@yourstore.com","admin","Valid"},
				{"admin@yourstore.com","adm","Invalid"},
				{"adm@yourstore.com	","admin","Invalid"},
				{"and@yourstore.com	","adnimsfd","Invalid"}

		};
		return logindata;
	}

}
