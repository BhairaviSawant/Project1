package page_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Assert;

public class Login {
	
	@FindBy(className = "login_logo")//loc = values fix
	private  WebElement LaunchText;
	@FindBy(name = "user-name")//loc = values fix
	private  WebElement Email_id;

	@FindBy( name = "password")
	private  WebElement passwd ;

	@FindBy( name = "login-button")
	private  WebElement Submit;
	
	@FindBy( xpath = "//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")
	private  WebElement errorMessage;
	@FindBy( xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
	private  WebElement invaliduser;
	
 
	public Login(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	public void Email(String fn ) {
		Email_id.clear();
		Email_id.sendKeys(fn);	
	}
	public void Password(String fn) {
		passwd.clear();
		passwd.sendKeys(fn);
	}
	public void Login(String Email, String pwd) 
	{
		Email_id.clear();
		Email_id.sendKeys(Email);	
		passwd.clear();
		passwd.sendKeys(pwd);
		
	}
	
	public void Submit() {
		Submit.click();
	}
	public String getErrorMessage() {
        //System.out.println("error captured for email"+Email_id.getText());
        return  errorMessage.getText();
        
        // Epic sadface: Username and password do not match any user in this service
    }
	public String invaliduser() {
        //System.out.println("error captured for email"+Email_id.getText());
        return  invaliduser.getText();
     
    }
	
	 public String getLaunchText() {
	        return LaunchText.getText();
	    }
}
