package com.training.pom;

import java.sql.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersHomeFromDashBoard {
	
	private WebDriver driver;


	public OrdersHomeFromDashBoard(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectvalue(WebElement webelement,String StringToCompare,String parameter) {
		List<WebElement> values=webelement.findElements(By.tagName(parameter));
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
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement addItem;
	
	@FindBy(xpath="//*[@id=\"input-customer-group\"]")
	private WebElement customergroup;

	
	@FindBy(xpath="//*[@id=\"button-invoice\"]/i")
	private WebElement GenerateIcon;
	
	@FindBy(name="order_status_id")
	private WebElement OrderStatus;
	
	@FindBy(xpath="//*[@id=\"input-order-status\"]/option[4]")
	private WebElement OrderStatusComplete;
	
	@FindBy(xpath="//*[@id=\"input-override\"]")
	private WebElement InputOverride;
	
	@FindBy(xpath="//*[@id=\"input-notify\"]")
	private WebElement NotifyCustomer;
	
	@FindBy(xpath="//*[@id=\"button-history\"]")
	private WebElement AddHistory;	
	
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement emailId;
	
	@FindBy(name="telephone")
	private WebElement telephone;
	
	@FindBy(id="button-customer")
	private WebElement continueButton;
	
	@FindBy(name="product")
	private WebElement productname;
	
	@FindBy(xpath="//*[@id=\"tab-product\"]/fieldset/div[1]/div/ul")
	private WebElement productnamedropdown;
	
	@FindBy(id="button-product-add")
	private WebElement addButton;
	
	@FindBy(id="button-cart")
	private WebElement continue1;
	
	@FindBy(id="input-payment-address-1")
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="country_id")
	private WebElement country;
	
	@FindBy(id="button-payment-address")
	private WebElement continueButton1;
	
	@FindBy(id="button-shipping-address")
	private WebElement continueButton2;
	
	@FindBy(id="input-payment-method")
	private WebElement paymentMethod;
	
	@FindBy(id="input-shipping-method")
	private WebElement shippingMethod;
	
	@FindBy(xpath="//*[@id=\"input-shipping-method\"]/optgroup/option")
	private WebElement shippingMethodfree;
	
	@FindBy(id="button-payment-method")
	private WebElement applyButton;
	
	@FindBy(id="button-shipping-method")
	private WebElement shippingMethodApplyButton;
	
	@FindBy(id="button-save")
	private WebElement saveButtonatlast;
	
	@FindBy(id="input-payment-zone")
	private WebElement zone;
	
	@FindBy(id="input-payment-firstname")
	private WebElement firstName1;
	
	@FindBy(id="input-payment-lastname")
	private WebElement lastName1;
	
	@FindBy(id="input-shipping-firstname")
	private WebElement firstName2;
	
	@FindBy(id="input-shipping-lastname")
	private WebElement lastName2;
	
	@FindBy(id="input-shipping-address-1")
	private WebElement address2;
	
	@FindBy(id="input-shipping-city")
	private WebElement city1;
	
	@FindBy(id="input-shipping-country")
	private WebElement country1;
	
	@FindBy(id="input-shipping-zone")
	private WebElement zone1;
	

	
	public void clickToNewButton() {
		addItem.click();
	}
	
	public void placingOrder(String name,String email,String phoneNumber) throws InterruptedException {
		selectvalue(customergroup, "testing123","option");
		//Enter valid credentials in First Name textbox
		firstName.sendKeys(name);
		//Enter valid credentials in Last Name textbox
		lastName.sendKeys(name);
		//Enter valid credentials in email textbox
		emailId.sendKeys(email);
		//Enter valid credentials in phone number textbox
		telephone.sendKeys(phoneNumber);
		//Click on Continue button
		continueButton.click();
		// Enter valid credentials in Choose Product textbox
		productname.sendKeys("Lorem ipsum dolor sit amet");
		// Enter valid credentials in Quantity textbox
		selectvalue(productnamedropdown, "Lorem ipsum dolor sit amet","li");
		//Click on Add product button
		addButton.click();
		Thread.sleep(3000);
		//click on continue button
		continue1.click();
		//Enter valid credentials in First Name textbox
		firstName1.sendKeys(name);
		//Enter valid credentials in last Name textbox
		lastName1.sendKeys(name);
		//Enter valid credentials in address textbox
		address.sendKeys("Yesvanthpur");
		//Enter valid credentials in city textbox
		city.sendKeys("Bangalore");
		//Enter valid credentials in country textbox
		selectvalue(country,"India","option");
		Thread.sleep(3000);
		//Enter valid credentials in state textbox
		selectvalue(zone,"Karnataka","option");
		//click on continue button
		continueButton1.click();
		firstName2.sendKeys(name);
		lastName2.sendKeys(name);
		address2.sendKeys("Yesvanthpur");
		city1.sendKeys("Bangalore");
		selectvalue(country1,"India","option");
		selectvalue(zone1,"Karnataka","option");
		continueButton2.click();
		selectvalue(shippingMethod, "Free Shipping - Rs.0", "option");
		Thread.sleep(5000);
		shippingMethod.click();
		Thread.sleep(3000);
		shippingMethodfree.click();
		shippingMethodApplyButton.click();
		//select payment method
		selectvalue(paymentMethod,"Cash On Delivery","option");
		Thread.sleep(5000);
		applyButton.click();
		Thread.sleep(5000);
		//Save
		saveButtonatlast.click();
	}

	
	public void OpenOptionsAndGenerateIcon() {
		GenerateIcon.click();
	}
	
	
	public void ChooseOrderStatus() {
		OrderStatus.click();
	}
	
    public void SelectOrderStatusComplete() {
    	OrderStatusComplete.click();
    }
    
    public void ChooseInputOverride() {
    	InputOverride.click();
    }
	
    public void ChooseNotifyCustomer() {
    	NotifyCustomer.click();
    }
	
	public void ChooseAddHistory() {
		AddHistory.click();
	}
	
	@FindBy(id="input-order-id")
	private WebElement orderId;
	
	@FindBy(id="input-order-status")
	private WebElement orderStatus_filter;
	
	@FindBy(id="input-date-added")
	private WebElement dateAdded;
	
	@FindBy(id="input-customer")
	private WebElement customerName_filter;
	
	@FindBy(id="input-total")
	private WebElement total;
	
	@FindBy(id="input-date-modified")
	private WebElement dateModified;
	
	@FindBy(id="button-filter")
	private WebElement filterButton;
	
	
	public void filterCustomer(String orderid,String status,String dateAdded2,String customername,String totalValue,String datemodified) throws InterruptedException {
		orderId.sendKeys(orderid);
		selectvalue(orderStatus_filter, status, "option");
		String dateAddedinput=dateAdded2.toString();
		dateAdded.sendKeys(dateAddedinput);
		customerName_filter.sendKeys(customername);
		total.sendKeys(totalValue);
		String dateModifiedInput=datemodified.toString();
		dateModified.sendKeys(dateModifiedInput);
		filterButton.click();
		Thread.sleep(3000);
	}
}




	