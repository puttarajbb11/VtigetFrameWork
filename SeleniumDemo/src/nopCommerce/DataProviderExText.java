package nopCommerce;

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExText {
	@Test(dataProvider = " dataProvider_Test")
		
		public void contactDetails(String firstname, String lastname, String Mobile)
		{
			String key = "webdriver.chrome.driver";
			String value = "./chromedriver.exe";
			System.setProperty(key, value);
			
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://localhost:8888/");
			// Login to application 
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
		
			// Creating Contact
			
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@Title='Create Contact...']")).click();
			
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("lastname");
			driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("Mobile");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			driver.quit();
			
		}
		
		@DataProvider
		public Object [][] dataProvider_Test()
		{
			Object [] [] objArr=new Object[3][3];
			
			objArr[0][0]="Puttaraja";
			objArr[0][1]="B";
			objArr[0][2]="886771452";
			
			objArr[1][0]="Santho";
			objArr[1][1]="m";
			objArr[1][2]="8867714585";
			
			objArr[1][0]="Muttu";
			objArr[1][1]="mahajana";
			objArr[1][2]="88677457585";
			
			
			return objArr;
		}
		}

	



