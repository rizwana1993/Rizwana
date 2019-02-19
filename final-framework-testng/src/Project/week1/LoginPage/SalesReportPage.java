package Project.week1.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalesReportPage {
	private WebDriver driver;


	public SalesReportPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(id="input-group")
	@FindBy(xpath="//*[@id=\"input-group\"]/option[3]")
	private WebElement GroupBy;
	
	@FindBy(id="button-filter")
	private WebElement Filter;
	
	
	public void GroupByOrders(String option) {
		System.out.print(option);
		GroupBy.click();
		Filter.click();
	}

}
