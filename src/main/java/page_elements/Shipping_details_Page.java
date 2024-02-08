package page_elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Shipping_details_Page {
	
	
		// Ensure that the user can enter valid shipping information during the checkout process.
		@FindBy(xpath= "//span[contains(@class, 'title')]")
		private WebElement Page_Title; 
	
		@FindBy(id = "first-name")
	    private WebElement Firstname;

	    @FindBy(id = "last-name")
	    private WebElement Lastname;

	    @FindBy(id = "postal-code")
	    private WebElement Pincode;

	    @FindBy(css = ".btn_primary.cart_button")
	    private WebElement ContinueBtn;
	    
	    // verify  validations when null value is passed
	    @FindBy(css = ".error-message-container.error")
	    private WebElement errorMessage;

		
	
		public Shipping_details_Page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		// Fill the SHIPPING FORM from EXCEL
		
		public void CustomerDetails(String fn , String ln,String Pc) throws InterruptedException
		{
			
			
			Firstname.click();
			Firstname.clear();
			Firstname.sendKeys(fn);
			Lastname.click();
			Lastname.clear();
			Lastname.sendKeys(ln);
			Pincode.click();
			Pincode.clear();
			Pincode.sendKeys(Pc);		
		}
		 
		// Fill the SHIPPING FORM for one user
		public void Details(String fn , String ln,String Pc)throws InterruptedException
		{ 
			Firstname.clear();
			Firstname.sendKeys(fn);
			
			Lastname.clear();
			Lastname.sendKeys(ln);
			
			Pincode.clear();
			Pincode.sendKeys(Pc);		
		}
		
		public void ContinueBtn()
		 {
			ContinueBtn.click();
				}
		public String getErrorMessage()
		{
			System.out.println("Error Displayed"+errorMessage.getText());
	        return errorMessage.getText();
	    }
}
