package rahulshettyacademy.testcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.maintest.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.LoginPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.SelectCountry;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StandAloneTest extends BaseTest {

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ProductCatalogue pc= lp.loginDetails(input.get("email"), input.get("password"));
		pc.getProductList();
		WebElement prod= pc.getProductByName(input.get("product"));
		pc.clickCart(input.get("product"));
		CartPage cpp= pc.goToCart();
		cpp.getCartProducts();
		Boolean match=cpp.verifyProducts(input.get("product"));
		Assert.assertTrue(match);
		SelectCountry sc= cpp.clickCheckout();
		CheckOutPage cop= sc.selectCountry("india");
		String confirmMessage= cop.getMessage();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmMessage);
		
		
	}
	
	@Test(dependsOnMethods={"submitOrder"})
	
	public void OrderHistory() throws IOException
	{
		String productname= "ADIDAS ORIGINAL";
		ProductCatalogue pc= lp.loginDetails("applevr@gmail.com", "princessV*1");
		OrderPage op= pc.goToOrder();
		op.getItems();
		Assert.assertTrue(op.verifyOrderDisplay(productname));
		
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data=	getJasonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\DataReader.json");
	
		return new Object[][] {{data.get(0)},{data.get(1)}};
	
	}
	
	
	
	

}
