package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.GetDataBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-customer-inputs")
	public Object [][] getDBData1() {

		List<GetDataBean> list = new ELearningDAO().getData(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(GetDataBean temp : list){
			Object[]  obj = new Object[7];   //8 in case of testToDeleteRetestToDeleteReturnsOfCustomerUsingDB_test
			obj[0] = temp.getorder_id();
			obj[1] = temp.getcustomer();
			obj[2] = temp.getFirst_Name();
			obj[3] = temp.getLast_Name();
			obj[4] = temp.getemail_id();
			obj[5] = temp.getphone();
			obj[6] = temp.getproduct();
//			obj[7] = temp.getmodel();  //add this during testToDeleteRetestToDeleteReturnsOfCustomerUsingDB_test
			
			result[count ++] = obj; 
		}
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/IBM_ADMIN/Desktop/SELENIUM/ExternalInputs.xlsx";
		String sheetname = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs_RTTD_015")
	public Object[][] getExcelData_RTTD_015(){
		String fileName ="C:/Users/IBM_ADMIN/Desktop/SELENIUM/ExternalInputs.xlsx";
		String sheetname = "RTTD_015";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs_RTTD_016")
	public Object[][] getExcelData_RTTD_016(){
		String fileName ="C:/Users/IBM_ADMIN/Desktop/SELENIUM/ExternalInputs.xlsx";
		String sheetname = "RTTD_016";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs_RTTD_017")
	public Object[][] getExcelData_RTTD_017(){
		String fileName ="C:/Users/IBM_ADMIN/Desktop/SELENIUM/ExternalInputs.xlsx";
		String sheetname = "RTTD_017";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
