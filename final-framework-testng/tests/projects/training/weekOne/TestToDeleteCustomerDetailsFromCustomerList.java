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
import com.training.pom.CustomerPageDetails;
import com.training.pom.DashBoardDetails;
import com.training.pom.LoginPageDetails;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToDeleteCustomerDetailsFromCustomerList {
	
	private WebDriver driver;
	private LoginPageDetails LoginPageDetails;
	private static Properties properties;
	private DashBoardDetails DashBoardDetails;
    private CustomerPageDetails CustomerPageDetails;
	
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
		CustomerPageDetails=new CustomerPageDetails(driver);
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
	public void TestToDeleteCustomerDetailsFromCustomerList_test() throws InterruptedException {
		String xpath="/html/body/div[1]/nav/ul/li[7]/ul/li";
		String ListItem="Customers";
		String name="User one";
		
		// Click on Customer icon
		DashBoardDetails.OpenCustomerLink();	
		DashBoardDetails.chooseLineItems(xpath,ListItem);
		Thread.sleep(1000);
		// Click on Check box of the customer to delete
        CustomerPageDetails.DeleteCustomerFromTable1(name);
		Thread.sleep(1000);
		CustomerPageDetails.DeleteCustomerFromTable2();
		Thread.sleep(1000);
		CustomerPageDetails.DeleteCustomerFromTable3();
		Thread.sleep(1000);
		CustomerPageDetails.DeleteCustomerFromTable4();
		Thread.sleep(1000);
		CustomerPageDetails.DeleteCustomerFromTable5();
	}
}
