package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageDetails {
	private WebDriver driver;


	public CustomerPageDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name")
	private WebElement Customername; 
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(xpath="//*[@id=\"form-customer\"]/div/table/thead/tr/td[1]/input")
	private WebElement checkbox;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement Delete;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement AddNew;
	
	@FindBy(xpath="//*[@id=\"form-customer\"]/div/table/tbody/tr[1]/td[8]/a")
	private WebElement Edit;
	
	
	
	
	
	public void DeleteCustomerFromTable1(String name) {
		Customername.sendKeys(name);
	}
	
	public void DeleteCustomerFromTable2() {
		filter.click();
	}
	
	public void DeleteCustomerFromTable3() {
		checkbox.click();
	}
		
	public void DeleteCustomerFromTable4() {	
		Delete.click();
	}
		
	public void DeleteCustomerFromTable5() {	
		driver.switchTo().alert().accept();
		}
	
	public void AddNewCustomer() {
		AddNew.click();
		System.out.println("it fails at AddNewCustomer");
		}
	
	
	public void EditCustomer1() {
		Customername.click();
	}
	
	public void EditCustomer2(String customername) {
		Customername.sendKeys(customername);
	}
	
	public void EditCustomer3() {
		filter.click();
	}
	
	public void EditCustomer4() {
		Edit.click();
	}
	
}
