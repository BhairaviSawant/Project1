package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Inventory_page {
	
	private WebDriver driver;
	
	@FindBy( xpath = "//div[@class='inventory_item_price']")
	private  WebElement Price;
	
	
	public Inventory_page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public int countProductImages() {
        List<WebElement> productImages = driver.findElements(By.xpath("//a[contains(@id, '_img_link')]"));
        return productImages.size();
    }

    public boolean isProductImagePresent(int imageIndex) {
    	
        List<WebElement> productImages = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for (WebElement productImage : productImages) {
            String imageText = productImage.getText();
            System.out.println("Image Text: " + imageText);
        }
        return imageIndex >= 0 && imageIndex < productImages.size();
    }
    
    public void ClickonProduct() throws InterruptedException {
    	
    	System.out.println("click on Product");

        List<WebElement> productImages = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for (int i = 0; i < productImages.size(); i++) {
            WebElement product = driver.findElements(By.xpath("//div[@class='inventory_item_name ']")).get(i);
            String imageText = product.getText();
            System.out.println("Image Text: " + imageText);
            product.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
                 
        }
    }
    
public void AddToCart() throws InterruptedException {
    	
    	System.out.println("Add to cart");

        List<WebElement> Add_Cartbtn = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        for (int i = 0; i < Add_Cartbtn.size(); i++) {
            WebElement cart_btn = driver.findElements(By.xpath("//button[contains(@class, 'btn_inventory ')]")).get(i);
            String imageText = cart_btn.getText();
            System.out.println("Cart Action Button: " + imageText);
            cart_btn.click();          
            Thread.sleep(2000);
                 
        }
    }

public void RemoveBtn() throws InterruptedException {
    	
    	System.out.println("Remove From Cart");

        List<WebElement> Remove_Cartbtn = driver.findElements(By.xpath("//button[contains(@id, 'remove')]"));
        for (int i = 0; i < Remove_Cartbtn.size(); i++) {
            WebElement cart_btn = driver.findElements(By.xpath("//button[contains(@class, 'btn_inventory ')]")).get(i);
            String imageText = cart_btn.getText();
            System.out.println("Cart Action Button :" + imageText);
            cart_btn.click();          
            Thread.sleep(2000);
                 
        }
    }
 
}
