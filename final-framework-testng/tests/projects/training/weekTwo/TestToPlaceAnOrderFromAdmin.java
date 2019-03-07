package projects.training.weekTwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddCustomerDetails;
import com.training.pom.CustomerGroupPage;
import com.training.pom.CustomerPageDetails;
import com.training.pom.DashBoardDetails;
import com.training.pom.EditCustomerPageDetails;
import com.training.pom.LoginPageDetails;
import com.training.pom.ManufacturersPage;
import com.training.pom.OrdersHomeFromDashBoard;
import com.training.pom.ProductsPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToPlaceAnOrderFromAdmin {
	public WebDriver driver;
	public LoginPageDetails LoginPageDetails;
	public DashBoardDetails DashBoardDetails;
	public CustomerGroupPage CustomerGroupPage;
	public CustomerPageDetails CustomerPageDetails;
	public EditCustomerPageDetails EditCustomerPageDetails;
	public AddCustomerDetails AddCustomerDetails;
	private static Properties properties;
	private OrdersHomeFromDashBoard OrdersHomeFromDashBoard;
	private ProductsPage ProductsPage;
	
	
	
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
		CustomerPageDetails=new CustomerPageDetails(driver);
		ProductsPage=new ProductsPage(driver);
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
	public void TestToPlaceAnOrderFromAdmin_test() throws InterruptedException {
		//click on Sales icon
		DashBoardDetails.OpenSalesIcon();
		Thread.sleep(1000);
		//Click on Orders link
		DashBoardDetails.chooseLineItems("//*[@id=\"menu-sale\"]/ul/li", "Orders");
		Thread.sleep(1000);
		//Click on Add New icon
		OrdersHomeFromDashBoard.clickToNewButton();
		Thread.sleep(1000);
		//Enter the values (Defined in OrdersHomeFromDashBoard.jave)
		OrdersHomeFromDashBoard.placingOrder("testing", "testing@test.com", "9999999999");
		
		

}
}