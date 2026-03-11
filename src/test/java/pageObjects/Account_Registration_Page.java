package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Registration_Page extends BasePage{

	public Account_Registration_Page(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_Firstname;
	
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_Lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Emailid;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void settxt_Firstname(String fname)
	{
		txt_Firstname.sendKeys(fname);
	}
	
	public void settxt_Lastname(String lname) {
		
		txt_Lastname.sendKeys(lname);
	}
	
	public void settxt_Emailid(String email) {
		
		txt_Emailid.sendKeys(email);
	}
	
	public void settxtTelephone(String tel) {
		
		txtTelephone.sendKeys(tel);
	}
	
	public void settxt_Password(String psswrd) {
		
		txt_Password.sendKeys(psswrd);
	}
	
	public void settxtConfirmPassword(String psswrd) {
		
		txtConfirmPassword.sendKeys(psswrd);
	}
	
	public void setchkdPolicy() {
		
		chkdPolicy.click();
	}
	
	public void setbtnContinue() {
		
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		
		try 
		{
			return(msgConfirmation.getText());
			
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
