package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.LoginPage;
import pageObjects.MyAccount_Page;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT_Test extends BaseClass
{
        @Test(dataProvider="loginData",dataProviderClass = DataProviders.class,groups = {"sanity","regression","Master"})
       public void verify_loginddt(String email,String password,String exp) 
       {
		
		try {
			
			
			//home page
			Home_Page hp=new Home_Page(driver);
			hp.clickmyAccount();
			//hp.clickregister();
			hp.clickmylogin();
			
			
			
			
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.settxtemailid(email);
		lp.settxtpassword(password);
		lp.clicklogin();
		
		//MyAccount page
		MyAccount_Page mypage=new MyAccount_Page(driver);
		boolean targetpage=mypage.isMyAccountPageExists();
		
	      if(exp.equalsIgnoreCase("valid"))
	      {
	    	  if(targetpage==true)
	    	  {
	    		  mypage.clicklogout();
	    		  Assert.assertTrue(true);
	    	  }
	    	  else 
	    	  {
				Assert.assertTrue(false);
			  }
	      }
	       if(exp.equalsIgnoreCase("invalid"))
	       {
	    	   if(targetpage==true)
	    	   {
	    		   mypage.clicklogout();
	    		   Assert.assertTrue(false);
	    	   }
	    	   else 
	    	   {
				Assert.assertTrue(true);
			   }
	       }
		}
	    catch (Exception e) 
	    {
		    e.getMessage();
	    	
	    }
	
	
	
	
	
		
	
	
	
	
       }	
	
	
}
