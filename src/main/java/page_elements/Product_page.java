package page_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Product_page {
	
	private WebDriver driver;
// click on individual product to land on product page
	@FindBy(id="item_4_title_link")
	private WebElement firstproduct ;
	@FindBy(xpath ="//div[contains(@class,'inventory_details_name large_size')]")
	private WebElement ProdName;
	
	@FindBy(id ="back-to-products")
	private WebElement Backbtn;
	
	@FindBy(id ="add-to-cart-sauce-labs-backpack")
	private WebElement Addtocart;
	
	// 
	

	String ExpectedURL = "https://www.saucedemo.com/inventory-item.html?id=4";
	public Product_page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	// Back btn action on product page
	public void Product_action() throws InterruptedException
	{	
		firstproduct.click();
		System.out.println("Product name: "+ProdName.getText());
		Thread.sleep(2000);
		Backbtn.click();
	}
	// Get URL TO VERIFY IF NEW PAGE OF PROD IS OPENED
	public void redirectLink()
	{
		firstproduct.click();
		System.out.println("Current URL: "+driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),ExpectedURL);

	}
	// Add Prod to bag
	
	public void Addtocart()
	{
		firstproduct.click();
		Addtocart.click();

	}
}
