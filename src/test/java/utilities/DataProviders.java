package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
@Test
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		String path=".//testDATA//Opencart_LoginData.xlsx";
		
		ExcelUtility exclUtils=new ExcelUtility(path);
		
		int totalrows=exclUtils.getRowCount("Sheet1");
		int totalcols=exclUtils.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=exclUtils.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
