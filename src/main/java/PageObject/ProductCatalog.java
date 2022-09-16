package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> products;
	@FindBy(xpath="//button[@class='btn w-10 rounded']")
	List<WebElement> productSelected;
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement myCart;
	
	
	By prodsDisplayy = By.xpath("//div[@id='toast-container']");
	
	
	public void SelectProductinCatalog(String product) {
	
	for(int i=0;i <products.size();i++) {
		if(products.get(i).findElement(By.xpath("h5/b")).getText().equals(product)) {
			productSelected.get(i).click();
			
		}
	}
	}
	public void GoToMyCart() {
	WaitingForTheInvisibility(prodsDisplayy);
	myCart.click();
	}
	
		

}


