package projects.training.weekOne;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestToFilterReturnDetailsFromReportsModule {

	public static void main(String[] args) throws InterruptedException {
		
		System. setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\eclipse-workspace\\PROJECT\\chromedriver.exe");
		
		WebDriver chrome=new ChromeDriver();
		chrome.get("http://retail.upskills.in/admin/");
		
		
		
		WebElement Username=chrome.findElement(By.id("input-username")); //Username
		WebElement Password=chrome.findElement(By.id("input-password")); //password
		WebElement LoginButton=chrome.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button"));

		

		Username.sendKeys("admin");
		Password.sendKeys("admin@123");
		LoginButton.click();
		chrome.findElement(By.id("menu-report")).click();
		chrome.findElement(ById.xpath("//*[@id=\"menu-report\"]/ul/li[1]/a")).click();
//		chrome.findElement(ById.xpath("//*[@id=\"menu-report\"]/ul/li[1]/ul/li[3]/a")).click();
//	    chrome.findElement(ById.xpath("//*[@id=\"input-group\"]")).click();
//	    chrome.findElement(By.id("button-filter")).click();
		
		List<WebElement> items = chrome.findElements(By.xpath("//*[@id=\"menu-report\"]/ul/li[1]/ul/li"));
		int rows=items.size();
		System.out.println(rows);
		
		for(int i=0;i<rows;i++)
		{
			String compare[]=new String[rows];
			
			try {
			compare[i]=items.get(i).getText();
			System.out.println(compare[i]);
			if(compare[i].equals("Returns"))
			{
				items.get(i).click();

			}
			}
			catch (Exception e) {
				
			}
		}
	    chrome.findElement(ById.xpath("//*[@id=\"input-group\"]")).click();
	    chrome.findElement(By.id("button-filter")).click();
	}
}


