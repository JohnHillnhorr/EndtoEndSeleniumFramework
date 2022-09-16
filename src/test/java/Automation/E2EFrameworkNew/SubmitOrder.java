package Automation.E2EFrameworkNew;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.PaymentPage;
import PageObject.ProductCatalog;
import PageObject.myOrders;
import browserInitalize.BrowserInitialize;

public class SubmitOrder extends BrowserInitialize  {
	String product;
	String pID;
	@Test(dataProvider = "data-provider", groups="purchaseProduct")
	public void BuyProductFlow(HashMap<String, String> input) throws InterruptedException, IOException {
		
		this.product = input.get("product");
		lp.LoginToSite(input.get("email"), input.get("password"));
		ProductCatalog pc= new ProductCatalog(driver);
		pc.SelectProductinCatalog(product);
		pc.GoToMyCart();
		CartPage cp = new CartPage(driver);
		cp.CheckOut(product);
		PaymentPage pg = new PaymentPage(driver);
		pg.FillUpAndPlaceOrder();
		pID = pg.GetOrderId();
		
		
	}
	
	@Test(dependsOnMethods= {"BuyProductFlow"})
	public void ValidateOrderInHistory() {
		lp.LoginToSite("johnhbomb310@gmail.com", "Testing123");
		myOrders myOrder = new myOrders(driver);
		myOrder.GoToOrderHistory();
		Assert.assertTrue(myOrder.VerifyOrderId(pID));
		Assert.assertTrue(myOrder.VerifyProductName(product));
		
		
	}
	
	 @DataProvider (name = "data-provider")
     public Object[][] dpMethod() throws IOException{
		 
		 

		 List<HashMap<String, String>> data =	getDataToPurchase(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\dataForProductPurchase.json");

		// TODO Auto-generated catch block
	
		 
//     HashMap<String, String> userData = new HashMap<String, String>();
//     userData.put("email", "johnhbomb310@gmail.com");
//     userData.put("password", "Testing123");
//     userData.put("product", "IPHONE 13 PRO");
//     
//     HashMap<String, String> userData1 = new HashMap<String, String>();
//     userData1.put("email", "johnhillnhorr01@gmail.com");
//     userData1.put("password", "Testing123");
//     userData1.put("product", "ADIDAS ORIGINAL");
//	 
	 return new Object[][] {{data.get(0)}, {data.get(1)}};
     }
	
	
	
	
}
	
	

