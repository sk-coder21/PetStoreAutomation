package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/testData/Book2.xlsx"; 
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int rownum=xlutil.getRowCount("Sheet1");	
		int colcount=xlutil.getCellCount("Sheet1",1);
				
		String apidata[][]=new String[rownum][colcount];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=rownum;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<colcount;j++)  //0    i is rows j is col
			{
				apidata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return apidata;//returning two dimension array
				
	}
	
	
	//DataProvider 2
	
	@DataProvider(name="UserNames")
	public String []getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"/testData/Book2.xlsx"; 
		//Testing new code
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int rownum=xlutil.getRowCount("Sheet1");	
				
		String apidata[]=new String[rownum];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=rownum;i++)  //1   //read the data from xl storing in two deminsional array
		{		
	
				apidata[i-1]= xlutil.getCellData("Sheet1",i, 1);  //1,0
			}
		
	return apidata;//returning two dimension array
				
	}
	
	//DataProvider 3
	
	//DataProvider 4
}
