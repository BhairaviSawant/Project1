package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page_elements.Login;
import page_elements.Inventory_page;

public class Product_Testcase {
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
	void Product_page() 
	{
		Inventory_page pp = new Inventory_page(driver);
		int Countproduct =  pp.countProductImages();
		System.out.println("Count is: "+ Countproduct);
		// Validate the count
        Assert.assertEquals(Countproduct, 6, "Expected number of product images is not matching.");
	}
	
	@Test(priority=3)
	void Product_visibile() 
	{
		Inventory_page pp = new Inventory_page(driver);
        // Validate the presence of a specific product image (index 0 in this example)
        Assert.assertTrue(pp.isProductImagePresent(0), "Product image at index 0 is not present.");
   
	}
	
	@Test(priority=4)
	
	void Click_on_product() throws InterruptedException
	{
		Inventory_page click = new Inventory_page(driver);
		//click.ClickonProduct(0);
		click.ClickonProduct();
	}
	
}
