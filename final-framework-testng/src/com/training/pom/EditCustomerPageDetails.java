package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPageDetails {
	private WebDriver driver;
	
	public EditCustomerPageDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement FirstName;
	
	@FindBy(xpath="//*[@id=\"address\"]/li[2]/a")
	private WebElement Address1;
	
	@FindBy(name="address[1][postcode]")
	private WebElement PostalCode;
	
	@FindBy(xpath="//*[@id=\"form-customer\"]/ul/li[4]/a")
	private WebElement RewardPoints;
	
	@FindBy(xpath="//*[@id=\"input-reward-description\"]")
	private WebElement Description;
	
	@FindBy(xpath="//*[@id=\"input-points\"]")
	private WebElement Points;
	
	@FindBy(id="button-reward")
	private WebElement RewardButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement SaveButton;
	
	
	
	
	public void EditCustomerPage1(){
		FirstName.clear();
	}
	public void EditCustomerPage2(String firstname){
		FirstName.sendKeys(firstname);
	}
	public void EditCustomerPage3(){
		Address1.click();
	}
	public void EditCustomerPage4(){
		PostalCode.clear();
	}
	public void EditCustomerPage5(String postalcode){
		PostalCode.sendKeys(postalcode);
	}
	public void EditCustomerPage6(){
		RewardPoints.click();
	}
	public void EditCustomerPage7(String description){
		Description.sendKeys(description);
	}
	public void EditCustomerPage8(String points){
		Points.sendKeys(points);
	}
	public void EditCustomerPage9(){
		RewardButton.click();
	}
	public void EditCustomerPage10(){
		SaveButton.click();
	}
}

