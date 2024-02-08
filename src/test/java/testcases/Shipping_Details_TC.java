package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import excel_operations.readExcel;
import page_elements.Cart_page;
import page_elements.Login;
import page_elements.Product_page;
import page_elements.Shipping_details_Page;

public class Shipping_Details_TC {
	
	WebDriver driver;

	@BeforeTest
	void initialize() {
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
				
	}
	@Test(dataProvider = "data_provider",priority=2)
	 void Checkoutform( String fn , String ln,String Pc) throws InterruptedException  {	
		// Step 3: Fill Checkout details 
		Shipping_details_Page SP = new Shipping_details_Page(driver);
		SP.CustomerDetails(fn,ln,Pc);
		SP.ContinueBtn();
	 	driver.navigate().back();			
	}
	
@Test(priority=3)
	void CheckoutValidations() throws InterruptedException {
		
//		// Step 3: enter details
		Shipping_details_Page SP = new Shipping_details_Page(driver);
		SP.Details("", "", "");
		SP.ContinueBtn();
		Thread.sleep(2000);
		String errorMessage = SP.getErrorMessage();
        Assert.assertEquals(errorMessage, "Error: First Name is required\n" +
                                        "Error: Last Name is required\n" +
                                        "Error: Postal Code is required",
                                        "Validation message mismatch");
	}
	
	@AfterTest
	void Close()
	{
		driver.close();
	}
	

	@DataProvider(name = "data_provider" )
	Object[][] data() throws IOException {
		String path = "C:\\TestingWorkspace\\project1\\excelData\\Data_excel.xlsx";
		Object[][] data = readExcel.data_read(path,"Checkout_info");

		return data;
	}
	
}
