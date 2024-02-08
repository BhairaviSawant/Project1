package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import page_elements.Login;
import page_elements.Social_handles_Page;

public class Social_handles_tc {
	private WebDriver driver;
	
    @BeforeClass
    public void setUp() {
    	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
        Login At = new Login(driver);
		At.Login("standard_user", "secret_sauce");
		At.Submit();
    }

    @Test(priority=1)
    public void testSocialMediaIconsPresence() throws InterruptedException {
    	Social_handles_Page Shp = new Social_handles_Page(driver);
        Assert.assertTrue(Shp.areSocialMediaIconsPresent(), "Social media icons are not present on the page.");
    }
    @Test(priority=2)
    
    public void redirecToSocialPage1() throws InterruptedException{
    	Social_handles_Page Shp = new Social_handles_Page(driver);
    	Shp.redirecToTwitter(); 	
    }
    
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
