package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Account_Registration_Page;
import pageObjects.Home_Page;
import testBase.BaseClass;

public class Account_Registration_Test extends BaseClass{

	@Test(groups= {"sanity","Master"})
	public void verify_account_registration() {
		
		Home_Page hp=new Home_Page(driver);
		hp.clickmyAccount();
		hp.clickregister();
		
		
		Account_Registration_Page ARP=new Account_Registration_Page(driver);
		ARP.settxt_Firstname(randomString().toUpperCase());
		ARP.settxt_Lastname(randomString().toUpperCase());
		ARP.settxt_Emailid(randomAlphaNumeric()+"@gmail.com");
		ARP.settxtTelephone(randomNumber());
		String password=randomAlphaNumeric();
		ARP.settxt_Password(password);
		ARP.settxtConfirmPassword(password);
		ARP.setchkdPolicy();
		ARP.setbtnContinue();
		
		String confmsg=ARP.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
