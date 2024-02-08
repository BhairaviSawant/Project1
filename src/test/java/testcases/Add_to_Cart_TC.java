package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import page_elements.Login;
import page_elements.Inventory_page;

public class Add_to_Cart_TC {
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
	void Add_to_cart() throws InterruptedException
	{
		Inventory_page pp = new Inventory_page(driver);
		pp.AddToCart();
	}
	
	@Test(priority=3)
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
