package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsReturnPage {
private WebDriver driver;
	
	public ProductsReturnPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement addNewButton;
	
	@FindBy(id="input-order-id")
	private WebElement orderID;
	
	@FindBy(id="input-customer")
	private WebElement customerName;
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephonenumber;
	
	@FindBy(id="input-product")
	private WebElement productName;
	
	@FindBy(id="input-model")
	private WebElement modelNumber;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement saveButton;
	
	@FindBy(id="input-customer")
	private WebElement customerNameinFilterBox;
	
	@FindBy(id="button-filter")
	private WebElement filterButton;
	
	@FindBy(xpath="//*[@id=\"form-return\"]/div/table/tbody/tr[1]/td[1]/input")
	private WebElement checkBox;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement deleteButton;
	
	public void clickToAddNewButton() {
		addNewButton.click();
		
	}
	
	public void clickToSaveButton() {
		saveButton.click();
	}
	
	public void fillInTheMandatoryDetails(String oderid,String customername,String firstname,String lastname,String emailid,
			String contactnumber,String productname,String model) {
		orderID.sendKeys(oderid);
		customerName.sendKeys(customername);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(emailid);
		telephonenumber.sendKeys(contactnumber);
		productName.sendKeys(productname);
		modelNumber.sendKeys(model);	
		
	}
	
	public void fiterCustomer(String name) {
		customerNameinFilterBox.sendKeys(name);
		filterButton.click();
	}
	
	public void deleteEntry() {
		checkBox.click();
		deleteButton.click();
		driver.switchTo().alert().accept();
	}
	

}
