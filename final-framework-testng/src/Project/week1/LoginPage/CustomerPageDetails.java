package Project.week1.LoginPage;

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
	
	
	
	public void DeleteCustomerFromTable(String name) {
		Customername.sendKeys(name);
		filter.click();
		checkbox.click();
		Delete.click();
		driver.switchTo().alert().accept();
	}
	
}
