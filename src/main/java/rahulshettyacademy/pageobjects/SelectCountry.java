package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class SelectCountry extends AbstractComponents {

	WebDriver driver;
	
	public SelectCountry(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement selectCountry;
	
	By dialogueBox= By.cssSelector(".ta-results");
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement clickCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	public CheckOutPage selectCountry(String countryname)
	{
		selectCountry.sendKeys(countryname);
		waitForElementToAppear(dialogueBox);
		clickCountry.click();
		placeorder.click();
		CheckOutPage cop= new CheckOutPage(driver);
		return cop;
		
		
	}
	
	
	
	
	
	
	
	
}
