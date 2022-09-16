package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> productName;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkOut;
	
	
	
	public void CheckOut(String product) {
	
	boolean productIsDisplay = productName.stream().anyMatch(s->s.getText().equals(product));
	Assert.assertTrue(productIsDisplay);
	checkOut.click();
	}
}
