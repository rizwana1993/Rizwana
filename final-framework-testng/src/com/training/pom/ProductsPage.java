package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	private WebDriver driver;


	public ProductsPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement addNewButton;
	
	@FindBy(name="product_description[1][name]")
	private WebElement productName;
	
	@FindBy(name="product_description[1][meta_title]")
	private WebElement metaTagTitle;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/")
	private WebElement selectFromList;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement saveButton;
	
	@FindBy(name="model")
	private WebElement model;
	
	@FindBy(name="price")
	private WebElement price;
	
	@FindBy(name="minimum")
	private WebElement quantity;
	
	@FindBy(name="manufacturer")
	private WebElement manufacturer;
	
	@FindBy(id="input-category")
	private WebElement categoryTextBox;
	
	
	public void clickToNewButton() {
		addNewButton.click();
	}
	
	public void fillGeneralDetails(String productname,String metaTagTitlename) {
		productName.sendKeys(productname);
		metaTagTitle.sendKeys(metaTagTitlename);
	}
	
	public void selectvalue(String StringToCompare) {
		List<WebElement> values=selectFromList.findElements(By.tagName("li"));
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
	
	public void chooseLineItems(String element) {
		List<WebElement> items = driver.findElements(By.xpath("//*[@id=\"form-product\"]/ul/li"));
		int rows=items.size();	
		System.out.println(rows);
		for(int i=0;i<rows;i++)
		{
			String compare[]=new String[rows];
			
			compare[i]=items.get(i).getText();
			if(compare[i].equals(element))   //"orders"
			{
				items.get(i).click();
				break;

			}
		}
	}
	
	
	public void enterDataDetails1() {
		chooseLineItems("Data");
	}
	public void enterDataDetails2() {
		model.sendKeys("SKU-012");
	}
	public void enterDataDetails3() {
		price.sendKeys("500");
	}
	public void enterDataDetails4() {
		quantity.sendKeys("50");
	}
	
	public void enterLinkDetails1() {
		chooseLineItems("Links");
	}
	public void enterLinkDetails2(String manufacturername) {
		manufacturer.sendKeys(manufacturername);
	}
	public void enterLinkDetails3() {
		categoryTextBox.sendKeys("Electronic1");
	}
	

	public void clickToSaveButton() {
		saveButton.click();		
	}
	
	public void clickToAttribute() {
		chooseLineItems("Attribute");	
	}
	

}
