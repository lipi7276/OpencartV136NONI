package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.text.html.parser.DTD;

import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
    
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups = {"Master","sanity","regression"})
	@Parameters({"os","browser"})
	public void Setup(String os,String browser) throws IOException 
	{
	   

		//loading config.properties file
		FileReader file=new FileReader(".//src/test/resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//loading log4j file 
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities cp=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				cp.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
		        cp.setPlatform(Platform.WIN11);		
			}
			else
			{
				System.out.println("not matching");
				return;
			}
			
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome": cp.setBrowserName("chrome"); break;
			case "edge" : cp.setBrowserName("edge"); break;
			case "firefox" : cp.setBrowserName("firefox"); break;
			default: System.out.println("no match"); return;
			}
			
		driver=new RemoteWebDriver(new URL(" http://10.226.189.80:4444"),cp);
			
		}
		
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			
		switch(browser.toLowerCase())
		{
		case"chrome" : driver=new ChromeDriver(); break;
		case"edge"   : driver=new EdgeDriver(); break;
		case"firefox": driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}
	
	
	}
	
	
	@AfterClass(groups = {"Master","sanity","regression"})
	public void teardown() 
	{
		
		driver.quit();
	}
	
	
	
	public String randomString() 
	{
		
		String ganeratedString=RandomStringUtils.randomAlphabetic(7);
		return ganeratedString;
	}
	
	
	
	public String randomNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(3);
		return generatedString;
	}
	
	
	
	
	public String randomAlphaNumeric()
	{
		String string=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(string+num);
	}
	
	public String capturescreenshot(String testname)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String targetfilepath=System.getProperty("user.dir")+"screenshots"+testname+"_"+timestamp+".png";
		File targetfile=new File(targetfilepath);
		sourceFile.renameTo(targetfile);
		
		return targetfilepath;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
	

