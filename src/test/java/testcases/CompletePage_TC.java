package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_elements.Cart_page;
import page_elements.CheckoutPage2;
import page_elements.Login;
import page_elements.Product_page;
import page_elements.Shipping_details_Page;

public class CompletePage_TC {
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
	void CheckoutValidations() throws InterruptedException {
		
		CheckoutPage2 Cp = new CheckoutPage2(driver);

	// Step 4: Validate if Verify Finish button Navigate to Checkout: Complete! Page
		Cp.Finish();
		Cp.orderCompletepage();
	}
	}
