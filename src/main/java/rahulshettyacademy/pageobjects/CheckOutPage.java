package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".hero-primary")
	WebElement message;
	
	
	public String getMessage()
	{
		return message.getText();
	}
	
	
	
}
