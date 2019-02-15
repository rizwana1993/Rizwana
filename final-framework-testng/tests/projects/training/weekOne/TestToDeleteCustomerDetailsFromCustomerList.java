package projects.training.weekOne;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestToDeleteCustomerDetailsFromCustomerList {

	public static void main(String[] args) throws InterruptedException 
	{
		System. setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\eclipse-workspace\\PROJECT\\chromedriver.exe");
		
		//initialising webdriver
		WebDriver Wd=new ChromeDriver();
		Wd.get("http://retail.upskills.in/admin/");
		
		//Login
		Wd.findElement(By.xpath("//*[@id=\"input-username\"]")).sendKeys("admin");

		Wd.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("admin@123");
		Wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")).click();	
		
		
		//customericon
		Wd.findElement(By.xpath("//*[@id=\"menu-customer\"]/a")).click();
		
		//customerlink
		Wd.findElement(By.xpath("//*[@id=\"menu-customer\"]/ul/li[1]/a")).click();
		
		//checkbox of customer
		Wd.findElement(By.xpath("//*[@id=\"form-customer\"]/div/table/tbody/tr/td[1]/input")).click();
		
		
		//Delete
		Wd.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button")).click();
		
		//Confirm OK
		Wd.switchTo().alert().accept();
		
		
		
	}
}
