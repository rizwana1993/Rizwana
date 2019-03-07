package projects.training.weekOne;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DashBoardDetails;
import com.training.pom.LoginPageDetails;
import com.training.pom.ShippingReportPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToFilterShippingDetails {
	private WebDriver driver;
	private LoginPageDetails LoginPageDetails;
	private static Properties properties;
	private DashBoardDetails DashBoardDetails;
	private ShippingReportPage ShippingReportPage;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPageDetails = new LoginPageDetails(driver); 
		properties.getProperty("baseURL");
		new ScreenShot(driver); 
		DashBoardDetails=new DashBoardDetails(driver);
		ShippingReportPage=new ShippingReportPage(driver);
		// open the browser 
		driver.get("http://retail.upskills.in/admin/");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@BeforeMethod
	public void validLoginTest() {
		LoginPageDetails.sendUserName1();
		LoginPageDetails.sendUserName2("admin");
		LoginPageDetails.sendPassword1();
		LoginPageDetails.sendPassword2("admin@123");
		LoginPageDetails.clickLoginBtn(); 
//		screenShot.captureScreenShot("First");
	}
	@Test
	public void TestToFilterReportFromReportsModule_test() throws InterruptedException {
		String xpath="//*[@id=\"menu-report\"]/ul/li";
		String ListItem="Sales";
		String ListItem2="Shipping";
		String option="Weeks";
		String xpath1="//*[@id=\"menu-report\"]/ul/li[1]/ul/li";
		
		//Click on Reports icon
		DashBoardDetails.OpenreportLink();
		//Click on Sales link
		DashBoardDetails.chooseLineItems(xpath,ListItem);
		Thread.sleep(1000);
		//Click on Shipping link
		DashBoardDetails.chooseLineItems(xpath1,ListItem2);	
		Thread.sleep(1000);
		// Click on Group By list box
		ShippingReportPage.GroupByOrders1(option);
		Thread.sleep(1000);
		//select valid credentials from Group By list box
		ShippingReportPage.GroupByOrders2();
		Thread.sleep(1000);
		//click on Filter button
		ShippingReportPage.GroupByOrders3();
	}
	}