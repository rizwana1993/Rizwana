package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class ManufacturersPage {
	private WebDriver driver;


	public ManufacturersPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement addNewButton;
	
	@FindBy(name="name")
	private WebElement manufacturerName;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement saveButton;
	
	public void addNewManufacturer1() {
		addNewButton.click();
	}
    public void addNewManufacturer2(String manufacturername) {
		manufacturerName.sendKeys(manufacturername);
    }
	public void addNewManufacturer3() {	
		saveButton.click();
		
	}
	
	
	
}
