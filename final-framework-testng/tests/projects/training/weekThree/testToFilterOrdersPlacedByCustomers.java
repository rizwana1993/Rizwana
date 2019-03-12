package projects.training.weekThree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.pom.DashBoardDetails;
import com.training.pom.LoginPageDetails;
import com.training.pom.SalesReportPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class testToFilterOrdersPlacedByCustomers {
	
	private WebDriver driver;
	private LoginPageDetails LoginPageDetails;
	private static Properties properties;
	private DashBoardDetails DashBoardDetails;
    private OrdersHomeFromDashBoard ordersHomeFromDashBoard;
	
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
		new CustomerPageDetails(driver);
		new SalesReportPage(driver);
		ordersHomeFromDashBoard=new OrdersHomeFromDashBoard(driver);
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
	@Test(dataProvider = "excel-inputs_RTTD_017", dataProviderClass = LoginDataProviders.class)
	public void testToFilterOrdersPlacedByCustomers_test(String orderid,String orderStatus,String DateAdded,String customer,String total,String DateModified) throws InterruptedException {
//		if(!orderid.equals("") && !orderStatus.equals("") && !DateAdded.equals("") && !customer.equals("") && !customer.equals("") && !total.equals("") && !DateModified.equals(""))
		{
			String xpath="//*[@id=\"menu-sale\"]/ul/li";
		DashBoardDetails.OpenSalesIcon();
		Thread.sleep(3000);
		DashBoardDetails.chooseLineItems(xpath, "Orders");
		ordersHomeFromDashBoard.filterCustomer(orderid, orderStatus, DateAdded, customer, total, DateModified);
		}	
	}
}
