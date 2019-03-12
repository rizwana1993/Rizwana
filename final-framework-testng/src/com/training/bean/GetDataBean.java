package com.training.bean;

public class GetDataBean {
	private String order_id;
	private String customer;
	private String First_Name;
	private String Last_Name;
	private String email_id;
	private String phone;
	private String product;
	private String model;

	public GetDataBean() {
	}

	public GetDataBean(String order_id, String customer,String First_Name,String Last_Name,String email_id,
			String phone,String product,String model) {
		super();
		this.order_id = order_id;
		this.customer = customer;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.email_id = email_id;
		this.phone = phone;
		this.product = product;
		this.model = model;
	}

	public String getorder_id() {
		return order_id;
	}

	public void setorder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getcustomer() {
		return customer;
	}

	public void setcustomer(String customer) {
		this.customer = customer;
	}
	
	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}
	
	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}
	
	public String getemail_id() {
		return email_id;
	}

	public void setemail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}
	
	public String getproduct() {
		return product;
	}

	public void setproduct(String product) {
		this.product = product;
	}
	
	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}
	
	

	@Override
	public String toString() {
		return "GetDataBean [order_id=" + order_id + ", customer=" + customer + ", First Name= " + First_Name + ",Last Name = " + Last_Name + ", email Id = " 
	+ email_id + " , Phone number = " + phone + " , Productname = " + product + " , Model = " + model + "]";
	}


}
