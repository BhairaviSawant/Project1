package page_elements;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Social_handles_Page {

	private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Facebook')]")
    private WebElement facebookIcon;

    @FindBy(xpath = "//a[contains(text(), 'Twitter')]")
    private WebElement twitterIcon; 

    @FindBy(xpath = "//a[contains(text(), 'LinkedIn')]")
    private WebElement linkedinIcon;
    

    // Constructor
    public Social_handles_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify the presence of social media icons
    public boolean areSocialMediaIconsPresent() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the webpage by pixel
        js.executeScript("window.scrollBy(0, 2000)");
        return facebookIcon.isDisplayed() && twitterIcon.isDisplayed() && linkedinIcon.isDisplayed();
    }
    
    public void redirecToTwitter() throws InterruptedException
    {
    	String ExpectedURL = "https://twitter.com/saucelabs";
    	// verify if ICONS are clickable and redirects to Social handles
    			twitterIcon.click();
    			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    	        driver.switchTo().window(tabs.get(1));
    			Assert.assertEquals(driver.getCurrentUrl(),ExpectedURL);
    			Thread.sleep(2000);
    			driver.navigate().back();
    			
    }
    
    public void redirecToFb()
    {
    	String ExpectedURL = "https://www.facebook.com/saucelabs";
    	// verify if ICONS are clickable and redirects to Social handles
    			facebookIcon.click();
    			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    	        driver.switchTo().window(tabs.get(1));
    			Assert.assertEquals(driver.getCurrentUrl(),ExpectedURL);
    }
}
