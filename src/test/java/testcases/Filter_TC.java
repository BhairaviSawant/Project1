package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import page_elements.Filters_Page;
import page_elements.Login;

public class Filter_TC {
	private WebDriver driver;
    

    @BeforeMethod
    public void setUp() throws InterruptedException {
    	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		Login At = new Login(driver);
		
		At.Login("standard_user", "secret_sauce");
		Thread.sleep(2000);
		At.Submit();	
    }


    @Test
    public void testSortByPriceLowToHigh() throws InterruptedException {
        // Apply filter
    	// Initialize Page Object
        Filters_Page Fp = new Filters_Page(driver);
        Fp.sortByPriceLowToHigh();
        Thread.sleep(2000);
        // checking the first and last price
        double firstPrice = Double.parseDouble(driver.findElement(By.className("inventory_item_price")).getText().replace("$", ""));
        
        double lastPrice = Double.parseDouble(driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[last()]")).getText().replace("$", ""));
        System.out.println("firstPrice : "+firstPrice+" lastPrice ;"+lastPrice);
        
        Assert.assertTrue(firstPrice <= lastPrice, "Prices are not sorted correctly: Low to High");
    }
    

    @AfterMethod
    public void Close() {
       
        driver.quit();
    }

}
