package rahulshettyacademy.testcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.maintest.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.LoginPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.SelectCountry;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

public class ErrorValidations extends BaseTest {

	@Test()
	public void loginErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String productname= "ADIDAS ORIGINAL";
		
		lp.loginDetails("applevr@gmail.com", "princssV*1");
		Assert.assertEquals("Incorrect email password.", lp.getErrorMessage());
		
	}
	
		
	
		
	@Test
	
	public void productErrorValidation() throws InterruptedException, IOException
	{
		String productname="ZARA COAT 3";
		ProductCatalogue pc= lp.loginDetails("applevr@gmail.com", "princessV*1");
		pc.getProductList();
		WebElement prod= pc.getProductByName(productname);
		pc.clickCart(productname);
		CartPage cpp= pc.goToCart();
		cpp.getCartProducts();
		Boolean match=cpp.verifyProducts("ZARA COAT 333");
		Assert.assertFalse(match);
	}
		
		
		
		
	

}
