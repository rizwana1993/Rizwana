package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardDetails {
	
	private WebDriver driver;


	public DashBoardDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id="menu-customer")
	private WebElement customericon; 
	
	@FindBy(xpath="/html/body/div[1]/nav/ul/li[7]/ul/li[1]")
	private WebElement customerLink;
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]")
	private WebElement ordersLink;
		
	@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[2]")
	private WebElement customerGroupLink;
	
	//@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[3]/a")
	//private WebElement CustomerReport;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/a/i")
	private WebElement report;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[3]/a")
	private WebElement Customerhyperlink;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[3]/ul/li[5]/a")
	private WebElement RewardsIcon;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/a")
	private WebElement LatestOrders;
	
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]/a")
	private WebElement SalesIcon;
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
	private WebElement OrdersIcon;
	
	@FindBy(id="menu-catalog")
	private WebElement catalogIcon;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[7]/a")
	private WebElement manufacturersLink;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]")
	private WebElement productsLink;
	
	public void OpenCustomerLink() {
		customerLink.click();
		}
	

	public void OpenCustomerIcon() {
		customericon.click();
	}
	
	public void OpenCustomerGroupLink() {
		customerGroupLink.click();
	}
	
	public void OpenreportLink() {
		report.click();
	}
	
	public void OpenCustomerHyperlink() {
		Customerhyperlink.click();
	}

	public void ReportCustomerIcon() {
		RewardsIcon.click();
	}
	
	public void OpenLatestOrders() {
		LatestOrders.click();
	}
	
	public void OpenSalesIcon() {
		SalesIcon.click();
	}
	
	public void OpenOrdersIcon() {
		OrdersIcon.click();
	}
	
	public void OpenCatalogueIcon() {
		catalogIcon.click();
	}
	
	public void OpenManufacturersLink() {
		manufacturersLink.click();
	}
	
	public void OpenProductsLink() {
		productsLink.click();
	}
	
	
		
	public void chooseLineItems(String xpath,String element) {
		List<WebElement> items = driver.findElements(By.xpath(xpath));
		int rows=items.size();		
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
	}
