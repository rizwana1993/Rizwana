package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerDetails {
	private WebDriver driver;
	
	public AddCustomerDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"input-customer-group\"]")
	private WebElement Customergroupid;
	
	@FindBy(name="firstname")
	private WebElement Firstname;
	
	@FindBy(name="lastname")
	private WebElement Lastname;
	
	@FindBy(name="email")
	private WebElement Email;
	
	@FindBy(name="telephone")
	private WebElement Telephone;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(name="confirm")
	private WebElement Confirm;
	
	@FindBy(xpath="//*[@id=\"address-add\"]/a")
	private WebElement Addaddress;
	
	@FindBy(name="address[1][firstname]")
	private WebElement Addressfirstname;
	
	@FindBy(name="address[1][lastname]")
	private WebElement Addresslastname;
	
	@FindBy(name="address[1][address_1]")
	private WebElement Address;
	
	@FindBy(name="address[1][address_2]")
	private WebElement Address2;
	
	@FindBy(name="address[1][city]")
	private WebElement City;
	
	@FindBy(name="address[1][postcode]")
	private WebElement Postcode;
	
	@FindBy(name="address[1][country_id]")
	private WebElement Country;
	
	@FindBy(name="address[1][zone_id]")
	private WebElement State;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement Save;
	
	
	public void selectvalue(WebElement webelement,String StringToCompare) {
		List<WebElement> values=webelement.findElements(By.tagName("option"));
		int size=values.size();
		System.out.println(size);
		
		for(int i=0;i<size;i++) {	
			String answer[]=new String[size];
			answer[i]=values.get(i).getText();	
			if(answer[i].equals(StringToCompare)){
				values.get(i).click();
			}
			
			
		}
		
	}
	

	public void AddCustomerDetails1(String customergroupname) {
		selectvalue(Customergroupid,customergroupname);
	}
	
	public void AddCustomerDetails2(String firstname){
		Firstname.sendKeys(firstname);
	}
	public void AddCustomerDetails3(String lastname){
		Lastname.sendKeys(lastname);
	}
	
	public void AddCustomerDetails4(String email){
		Email.sendKeys(email);
	}
	
	public void AddCustomerDetails5(String telephone){
		Telephone.sendKeys(telephone);
	}
	
	public void AddCustomerDetails6(String password){
		Password.sendKeys(password);
	}
	
	public void AddCustomerDetails7(String password){
		Confirm.sendKeys(password);
	}
	
	public void AddCustomerDetails8(){
		Addaddress.click();
	}
	
	public void AddCustomerDetails9(String firstname){
		Addressfirstname.sendKeys(firstname);
	}
	
	public void AddCustomerDetails10(String lastname){
		Addresslastname.sendKeys(lastname);
	}
	public void AddCustomerDetails11(String address){
		Address.sendKeys(address);
	}
	
	public void AddCustomerDetails12(String address2){
		Address2.sendKeys(address2);
	}
	
	public void AddCustomerDetails13(String city){
		City.sendKeys(city);
	}
	
	public void AddCustomerDetails14(String postcode){
		Postcode.sendKeys(postcode);
	}
	
	public void AddCustomerDetails15(String country){
		selectvalue(Country,country);
	}
	
	public void AddCustomerDetails16(String state){
		selectvalue(State,state);
	}
	
	public void AddCustomerDetails17(){
		Save.click();
	}
	
	
}
