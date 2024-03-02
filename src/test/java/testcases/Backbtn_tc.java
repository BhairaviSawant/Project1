package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import page_elements.Login;
import page_elements.Product_page;

public class Backbtn_tc {
	WebDriver driver;

	@BeforeTest
	void initialize() {
		 	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");

	} 
	@Test(priority=1)
	void Login() throws InterruptedException
	{// Step 1
		Login At = new Login(driver);
		
		At.Login("standard_user", "secret_sauce");
		At.Submit();
	}
	@Test(priority=2)
	void ProdPageAction() throws InterruptedException
	{// Step 2: add product
		Product_page pp = new Product_page(driver);
		pp.Product_action();
	}
	@Test(priority=3)
	void Verify_Redirect_Link() throws InterruptedException
	{
		// step 3: verify redirect 
		Product_page pp = new Product_page(driver);
		pp.redirectLink();
	}
	@AfterTest
	void Close()
	{
		driver.close();
		}
}
