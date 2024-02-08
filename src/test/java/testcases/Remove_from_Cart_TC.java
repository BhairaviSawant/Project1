package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_elements.Login;
import page_elements.Inventory_page;

public class Remove_from_Cart_TC {
	WebDriver driver;

	@BeforeTest
	void initialize() throws InterruptedException {
		 	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			
	}
	@Test(priority=1)
	void Login() throws InterruptedException
	{
		Login At = new Login(driver);
		
		At.Login("standard_user", "secret_sauce");
		Thread.sleep(2000);
		At.Submit();
	}
	
	@Test(priority=2)
	void RemoveBtn() throws InterruptedException
	{
		Inventory_page pp = new Inventory_page(driver);
		pp.AddToCart();
		pp.RemoveBtn();;
	}
	
	
	@AfterTest
	void close()
	{
		driver.close();
	}

}
