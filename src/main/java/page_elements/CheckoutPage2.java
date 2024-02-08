package page_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage2 {

	private WebDriver driver;
	 // Locators
    @FindBy(css = ".summary_subtotal_label")
    private WebElement subtotalLabel;

    @FindBy(css = ".summary_tax_label")
    private WebElement taxLabel;

    @FindBy(css = ".summary_total_label")
    private WebElement totalLabel;
    
    @FindBy(id = "finish")
    private WebElement FinishBtn;
    
    @FindBy(xpath= "//span[contains(@class, 'title')]")
	private WebElement Page_Title; 

	public CheckoutPage2(WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver,this);
	}
	
	// Methods to get billing details
    public String getSubtotal() {
    
        return subtotalLabel.getText();
    }

    public String getTax() {
        return taxLabel.getText();
    }

    public String getTotal() { 
        return totalLabel.getText();
    }
    
    public void Finish()
    {
    	FinishBtn.click();
    }
    
    public void orderCompletepage()
    {	String ExpectedTitle = "Checkout: Complete!";
    	// Prints title to verify if Checkout page  form is displayed
    			Assert.assertEquals(Page_Title.getText(),ExpectedTitle);
    }
	
}
