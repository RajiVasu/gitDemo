package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
	public List<WebElement> getCartProducts()
	{
		return cartproducts;
	}
	
	public Boolean verifyProducts(String productname)
	{
		Boolean match= cartproducts.stream().anyMatch(b->b.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public SelectCountry clickCheckout()
	{
		checkout.click();
		SelectCountry sc= new SelectCountry(driver);
		return sc;
		
		
		
	}
	
	
}
