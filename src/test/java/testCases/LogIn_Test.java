package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.LoginPage;
import pageObjects.MyAccount_Page;
import testBase.BaseClass;

public class LogIn_Test extends BaseClass{

	@Test(groups = {"regression","Master"})
	public void verify_login() {
		
		try {
			
		//home page
		Home_Page hp=new Home_Page(driver);
		hp.clickmyAccount();
		//hp.clickregister();
		hp.clickmylogin();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.settxtemailid(p.getProperty("email"));
		lp.settxtpassword(p.getProperty("password"));
		lp.clicklogin();
		
		//MyAccount page
		MyAccount_Page mypage=new MyAccount_Page(driver);
		boolean targetpage=mypage.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage,true);
		}
		catch (Exception e) {
			
	           Assert.fail();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
