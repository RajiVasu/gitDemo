package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errormessage;
	
	public ProductCatalogue loginDetails(String username, String password)
	{
		email.sendKeys(username);
		passwordele.sendKeys(password);
		submit.click();
		ProductCatalogue pc= new ProductCatalogue(driver);
		return pc;
		
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errormessage);
		return errormessage.getText();
		
	}
	
	public void goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client");

	}
	
	
	
}
