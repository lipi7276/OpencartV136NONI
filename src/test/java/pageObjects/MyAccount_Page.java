package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page extends BasePage {

	public MyAccount_Page(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgheading;
	
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btnlogout;
	
	public boolean isMyAccountPageExists()
	{
		try 
		{
			return(msgheading.isDisplayed());
		}
		catch (Exception e) {
			
			return false;
		}
		
	}
	
	public void clicklogout()
	{
		btnlogout.click();
	}
	
}
