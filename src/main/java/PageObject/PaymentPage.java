package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Location;
	@FindBy(xpath="//section[contains(@class,'ta-results')]")
	WebElement LocationSelected;
	@FindBy(xpath="//a[contains(text(),'Place Order')]")
	WebElement PlaceOrder;
	
	@FindBy(css="label[class='ng-star-inserted']")
	WebElement PrdctOrderId;
	
	
	
	By locResult = By.xpath("(//button[@type='button'])");
	

	
	
	public void FillUpAndPlaceOrder() {
		Actions a = new Actions(driver);
		a.sendKeys(Location, "lithuania").build().perform();
		WaitingForTheVisibility(locResult);
		
		LocationSelected.click();
		PlaceOrder.click();
	}
	
	public String GetOrderId() {
		return PrdctOrderId.getText().replace("|", "").trim();
	}
	
	
	
	
	

}
