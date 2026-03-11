package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage
{
    public Home_Page(WebDriver driver) 
    {
    	super(driver);
    }
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement mylogin;
	
	public void clickmyAccount() {
		
		myAccount.click();
	}
	
	public void clickregister() {
		
		register.click();
	}
	
	public void clickmylogin() {
		
		mylogin.click();
	}

}
