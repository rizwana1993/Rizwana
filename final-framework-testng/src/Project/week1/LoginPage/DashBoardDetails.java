package Project.week1.LoginPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(id="menu-report")
	private WebElement report;
	
//	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/a")
//	[1]/a
//	
	
	public void OpenCustomerLink() {
		customericon.click();
		}
	
	public void OpenreportLink() {
		report.click();
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
