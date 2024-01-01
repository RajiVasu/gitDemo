package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productBy= By.cssSelector(".mb-3");
	
	By toastMessage= By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
		
		
	}
	
	public WebElement getProductByName(String productname)
	{
		
		WebElement prod= products.stream().filter(a->a.findElement(By.tagName("b")).getText().contains(productname))
				.findFirst().orElse(null);
		
		return prod;
		
	}
	
	public void clickCart(String productname) throws InterruptedException
	{
		WebElement prod= getProductByName(productname);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear();
		
		
	}
	
	
	
}
