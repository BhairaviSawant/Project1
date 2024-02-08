package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_elements.Cart_page;
import page_elements.CheckoutPage2;
import page_elements.Login;
import page_elements.Product_page;
import page_elements.Shipping_details_Page;

public class Billing_Page_TC {
	WebDriver driver;
	  
	@BeforeTest
	void initialize() throws InterruptedException {
		 	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			
	}
	
	@Test(priority=1)
	void preconditions() throws InterruptedException
	{
				// Step 1 : Login 
				Login At = new Login(driver);
				
				At.Login("standard_user", "secret_sauce");
				At.Submit();
				
				//Step 2: Add Product and click on Checkout btn
				Product_page pp= new Product_page(driver);
				pp.Addtocart();
				Cart_page CP = new Cart_page(driver);
				CP.Checkout();			
				
				// Step 3: enter details
				Shipping_details_Page SP = new Shipping_details_Page(driver);
				SP.Details("Fname", "Lname", "23232323");
				SP.ContinueBtn();
	}
	
	@Test(priority=2)
	void Billing() throws InterruptedException
	{
		CheckoutPage2 Cp = new CheckoutPage2(driver);
		 // Verify billing details on checkout step two page
        Assert.assertEquals(Cp.getSubtotal(), "Item total: $29.99");
        Assert.assertEquals(Cp.getTax(), "Tax: $2.40");
        Assert.assertEquals(Cp.getTotal(), "Total: $32.39");
  
	}

}
