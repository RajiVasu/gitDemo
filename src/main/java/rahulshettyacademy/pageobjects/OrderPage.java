package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{

	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> items;
	
	
	
	public List<WebElement> getItems()
	{
		return items;
	}
	
	public Boolean verifyOrderDisplay(String productname)
	{
		Boolean match1= items.stream().anyMatch(c->c.getText().equalsIgnoreCase(productname));
		return match1;
	}
	
	
	
}
