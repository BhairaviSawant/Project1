package page_elements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cart_page {

	private WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(className= "shopping_cart_link" )
	private WebElement cart_btn;
	@FindBy(className= "shopping_cart_badge")
	private WebElement Prod_Count;
	@FindBy(xpath= "//span[contains(@class, 'title')]")
	private WebElement Page_Title; 
	@FindBy(xpath= "//button[text()='Remove']")
	private WebElement removeBtn;
	@FindBy(id= "checkout" )
	private WebElement CheckOut_btn;
	
	String ExpectedTitle = "Checkout: Your Information";
	 
	public Cart_page(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void Checkout() throws InterruptedException
	{	
		cart_btn.click();
		System.out.println("Count of Products : "+Prod_Count.getText());
		
		wait.until(ExpectedConditions.visibilityOf(CheckOut_btn));
		CheckOut_btn.click();
		wait.until(ExpectedConditions.visibilityOf(Page_Title));
		// Prints title to verify if Checkout page  form is displayed
		Assert.assertEquals(Page_Title.getText(),ExpectedTitle);
		System.out.println("Page Title: "+Page_Title.getText());
	}
	
	public void Removebtn() throws InterruptedException
	{
		cart_btn.click();
		wait.until(ExpectedConditions.visibilityOf(removeBtn));
		
	}
	
	
	
}
