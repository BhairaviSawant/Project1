package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_elements.Cart_page;
import page_elements.Login;
import page_elements.Product_page;

public class Cart_Action_Testcase {
	WebDriver driver;
  
	@BeforeTest
	void initialize() throws InterruptedException {
		 	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			Login At = new Login(driver);
			
			At.Login("standard_user", "secret_sauce");
			Thread.sleep(2000);
		 	At.Submit();
			
	}
	
	@Test(priority=1)
	void CheckoutBtn() throws InterruptedException
	{
		// Add Product and click on Checkout btn
		Product_page pp= new Product_page(driver);
		pp.Addtocart();
		Cart_page CP = new Cart_page(driver);
		CP.Checkout();
	}
	
	@Test(priority=2)
	void RemoveBtn() throws InterruptedException
	{
		// remove product from cart from product page
		Cart_page CP = new Cart_page(driver);
		CP.Removebtn();
	}
	
	@AfterTest
	void close()
	{
		driver.close();
	}

		
}
