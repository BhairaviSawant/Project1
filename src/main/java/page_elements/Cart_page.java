package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Cart_page {

	private WebDriver driver;
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
	}
	
	public void Checkout() throws InterruptedException
	{	
		cart_btn.click();
		System.out.println("Count of Products : "+Prod_Count.getText());
		Thread.sleep(2000);
		CheckOut_btn.click();
		Thread.sleep(2000);
		// Prints title to verify if Checkout page  form is displayed
		Assert.assertEquals(Page_Title.getText(),ExpectedTitle);
		System.out.println("Page Title: "+Page_Title.getText());
	}
	
	public void Removebtn() throws InterruptedException
	{
		cart_btn.click();
		Thread.sleep(2000);
		removeBtn.click();
		Thread.sleep(2000);
	}
	
	
	
}
