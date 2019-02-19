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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import Project.week1.LoginPage.*;

public class TestToFilterReturnDetails {
	private WebDriver driver;
	private LoginPageDetails LoginPageDetails;
	private static Properties properties;
	private DashBoardDetails DashBoardDetails;
	private ReturnsReportPage ReturnsReportPage;
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
		ReturnsReportPage=new ReturnsReportPage(driver);
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
		LoginPageDetails.sendUserName("admin");
		LoginPageDetails.sendPassword("admin@123");
		LoginPageDetails.clickLoginBtn(); 
//		screenShot.captureScreenShot("First");
	}
	@Test
	public void TestToFilterReportFromReportsModule_test() throws InterruptedException {
		String xpath="//*[@id=\"menu-report\"]/ul/li";
		String ListItem="Sales";
		String ListItem2="Returns";
		String option="Weeks";
		String xpath1="//*[@id=\"menu-report\"]/ul/li[1]/ul/li";
		
		DashBoardDetails.OpenreportLink();
		DashBoardDetails.chooseLineItems(xpath,ListItem);	
		DashBoardDetails.chooseLineItems(xpath1,ListItem2);	
		ReturnsReportPage.GroupByOrders(option);
	}
	}