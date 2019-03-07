package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerGroupPage {
	private WebDriver driver;


	public CustomerGroupPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a" )
	private WebElement AddNew;
	
	
	
	
	public void CreateCustomerGroup() {		
		AddNew.click();
		
	}
	
	
	
}
