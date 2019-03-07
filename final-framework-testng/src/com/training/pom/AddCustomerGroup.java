package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerGroup {

	
	private WebDriver driver;
	
	public AddCustomerGroup(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="customer_group_description[1][name]")
	private WebElement CustomerGroupName;
	
	@FindBy(name="customer_group_description[1][description]")
	private WebElement Description;
	
	@FindBy(xpath="//*[@id=\"form-customer-group\"]/div[3]/div/label[1]/input")
	private WebElement ApproveNewCustomer;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement save;
	
	
	
	
	public void AddCustomerGroupDetails1(String customergroupname) {
		CustomerGroupName.sendKeys(customergroupname);
	}
	
	public void AddCustomerGroupDetails2(String descriptiom) {
		Description.sendKeys(descriptiom);
	}
	
	public void AddCustomerGroupDetails3() {
		ApproveNewCustomer.click();
	}
	
	public void AddCustomerGroupDetails4() {
		save.click();
	}
		
		
	}
