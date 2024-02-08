package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_elements.Login;
import excel_operations.readExcel;

public class login_Testcase {
	WebDriver driver;

	@BeforeTest
	void initialize() {
		 	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			
			Login At = new Login(driver);
		   
	}
	 
	@Test(dataProvider = "data_provider")
	void reg_user( String email,String pwd) throws InterruptedException {

		Login At = new Login(driver);
		// Assert to verify launch screen
	    Assert.assertEquals(At.getLaunchText(), "Swag Labs", "Launch screen does not display 'Swag Labs'");
	    
	    // Login Testcases
		At.Login(email, pwd);
		Thread.sleep(2000);
		
		if (email.equals("locked_out_user") && pwd.equals("secret_sauce")) {
            // Check for the error message
			At.Submit();
            String errorMessage = At.getErrorMessage();
            Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
            driver.navigate().to(driver.getCurrentUrl());     
        }
		else {
		At.Submit();
		Thread.sleep(2000);
		driver.navigate().back();	
		}		
	}

	@AfterTest
	void Close()
	{
		driver.close();
	}
	
	@DataProvider(name = "data_provider" )
	Object[][] data() throws IOException {
		String path = "C:\\TestingWorkspace\\project1\\excelData\\Data_excel.xlsx";
		//String sheet_name = "Login";
		Object[][] data = readExcel.data_read(path,"Login");
//		data_excel_read.data_read(path,"reg");
		return data;
	}

}
