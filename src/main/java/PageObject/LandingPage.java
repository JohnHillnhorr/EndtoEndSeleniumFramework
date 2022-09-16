package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement pw;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement failedLoginError;
	
	
	public void LoginToSite(String userEmail, String PW) {
		email.sendKeys(userEmail);
		pw.sendKeys(PW);
		loginButton.click();
	}
	
	public void GotoSite() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String FailedLoginError() {
		return failedLoginError.getText();
	}
	
	
		
}


