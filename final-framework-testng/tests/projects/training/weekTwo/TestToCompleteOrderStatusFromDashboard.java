package projects.training.weekTwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCustomerDetails;
import com.training.pom.AddCustomerGroup;
import com.training.pom.CustomerGroupPage;
import com.training.pom.CustomerPageDetails;
import com.training.pom.DashBoardDetails;
import com.training.pom.LoginPageDetails;
import com.training.pom.OrdersHomeFromDashBoard;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToCompleteOrderStatusFromDashboard {
	public WebDriver driver;
	public LoginPageDetails LoginPageDetails;
	public DashBoardDetails DashBoardDetails;
	public OrdersHomeFromDashBoard OrdersHomeFromDashBoard;
	private static Properties properties;
	
	
	
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
		DashBoardDetails=new DashBoardDetails(driver);
		OrdersHomeFromDashBoard=new OrdersHomeFromDashBoard(driver);
		// open the browser 
		driver.get("http://retail.upskills.in/admin/");
	}
	
	@BeforeMethod
	public void validLoginTest() {
		LoginPageDetails.sendUserName1();
		LoginPageDetails.sendUserName2("admin");
		LoginPageDetails.sendPassword1();
		LoginPageDetails.sendPassword2("admin@123");
		LoginPageDetails.clickLoginBtn(); 
	}
	
	@Test
	public void TestToCompleteOrderStatusFromDashboard_test() throws InterruptedException {
		//Click on view icon of order placed by the customer in Latest Orders section
		DashBoardDetails.OpenLatestOrders();
		//Click on Generate icon of options section
		OrdersHomeFromDashBoard.OpenOptionsAndGenerateIcon();
		Thread.sleep(1000);
		OrdersHomeFromDashBoard.ChooseOrderStatus();
		Thread.sleep(1000);
		//Select valid credentials in Order status list box
		OrdersHomeFromDashBoard.SelectOrderStatusComplete();
		Thread.sleep(1000);
		OrdersHomeFromDashBoard.ChooseInputOverride();
		Thread.sleep(1000);
		OrdersHomeFromDashBoard.ChooseNotifyCustomer();
		Thread.sleep(1000);
		//Click on Add history button
		OrdersHomeFromDashBoard.ChooseAddHistory();
		
		
	}
}
