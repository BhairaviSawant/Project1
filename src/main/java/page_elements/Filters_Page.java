package page_elements;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;

	public class Filters_Page {
	    private WebDriver driver;

	    public Filters_Page(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void sortByPriceLowToHigh() {
	        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
	        dropdown.selectByValue("lohi");
	        
	    }
	}

