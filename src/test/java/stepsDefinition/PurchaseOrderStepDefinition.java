package stepsDefinition;



import java.io.IOException;

import org.testng.Assert;

import PageObject.CartPage;
import PageObject.PaymentPage;
import PageObject.ProductCatalog;
import browserInitalize.BrowserInitialize;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PurchaseOrderStepDefinition extends BrowserInitialize {

    @Given("^launch the E\\-Commerce Site$")
    public void launch_the_ecommerce_site() throws IOException{
    	GoToSite();
    }

    @When("^Login using username (.+) and (.+)$")
    public void login_using_username_and(String user, String password) {
    	lp.LoginToSite(user, password);
    }

    @When("^Add (.+) to Cart$")
    public void add_to_cart(String product) {
    	ProductCatalog pc= new ProductCatalog(driver);
		pc.SelectProductinCatalog(product);
		pc.GoToMyCart();
		CartPage cp = new CartPage(driver);
		cp.CheckOut(product);
    }

    @Then("^Successfully purchased the (.+)$")
    public void successfully_purchased_the(String product)  {
       System.out.println("Successfully purchased the " + product);
    }

    @And("^Submit and click Place Order$")
    public void submit_and_click_place_order() {
    	
		;
		PaymentPage pg = new PaymentPage(driver);
		pg.FillUpAndPlaceOrder();
		String pID = pg.GetOrderId();
		System.out.println(pID);
		driver.quit();
    }
    
    @Then("^\"([^\"]*)\" is displayed$")
    public void something_is_displayed(String strArg1) {
    	Assert.assertEquals(lp.FailedLoginError(), strArg1);
    	driver.close();
    }

}