package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.GetDataBean;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	
//	
//	public static void main(String[] args) {
//		new ELearningDAO().getLogins().forEach(System.out :: println);
//	}
	
	public List<GetDataBean> getData(){
		String sql = properties.getProperty("get.manufacturerdetails"); //get.customerdetails for testToDeleteRetestToDeleteReturnsOfCustomerUsingDB_test
		
		GetConnection gc  = new GetConnection(); 
		List<GetDataBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<GetDataBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				GetDataBean temp = new GetDataBean(); 
				temp.setorder_id(gc.rs1.getString(1));
				temp.setcustomer(gc.rs1.getString(2));
				temp.setFirst_Name(gc.rs1.getString(3));
				temp.setLast_Name(gc.rs1.getString(4));
				temp.setemail_id(gc.rs1.getString(5));
				temp.setphone(gc.rs1.getString(6));
				temp.setproduct(gc.rs1.getString(7));
//				temp.setmodel(gc.rs1.getString(8));  // add this during testToDeleteRetestToDeleteReturnsOfCustomerUsingDB_test

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	public static void main(String[] args) {
		new ELearningDAO().getData().forEach(System.out :: println);
	}
	
	
}
