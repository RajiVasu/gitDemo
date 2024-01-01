package rahulshettyacademy.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orders;
	
	public CartPage goToCart()
	{
		cart.click();
		CartPage cpp= new CartPage(driver);
		return cpp;
	}
	
	
	public OrderPage goToOrder()
	{
		orders.click();
		OrderPage op= new OrderPage(driver);
		return op;
	}
	
	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

	}
	
	public void waitForElementToAppear(WebElement FindBy)
	{
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(FindBy));

	}
	
	public void waitForElementToDisappear() throws InterruptedException
	{
		Thread.sleep(9000);

	}
	
	
	
	
}
