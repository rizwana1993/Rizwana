package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnsReportPage {
	private WebDriver driver;


	public ReturnsReportPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(id="input-group")
	@FindBy(xpath="//*[@id=\"input-group\"]/option[3]")
	private WebElement GroupBy;
	
	@FindBy(id="button-filter")
	private WebElement Filter;
	
	
	public void GroupByOrders1(String option) {
		System.out.print(option);
	}
	public void GroupByOrders2() {
		GroupBy.click();
	}
	public void GroupByOrders3() {
		Filter.click();
	}


}