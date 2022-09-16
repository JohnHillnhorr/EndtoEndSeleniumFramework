package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AbstractComponents.AbstractComponent;

public class myOrders extends AbstractComponent {
 WebDriver driver;
	public myOrders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//tbody/tr/th")
	List<WebElement> orderId;
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> productNames;
	
	
	
	
	public boolean VerifyOrderId(String productOrderId) {
		
	return orderId.stream().anyMatch(s->s.getText().equalsIgnoreCase(productOrderId));
	}
	
	public boolean VerifyProductName(String productName) {
		
	return productNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	}



public void GoToOrderHistory() {
	
	OrderHistory();
}


	
	
	
	
	
	

}
