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
import com.training.pom.CustomerPageDetails;
import com.training.pom.DashBoardDetails;
import com.training.pom.*;
import com.training.pom.SalesReportPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class testToDeleteReturnsOfCustomerUsingDB {
	
	private WebDriver driver;
	private LoginPageDetails LoginPageDetails;
	private static Properties properties;
	private DashBoardDetails DashBoardDetails;
    private ProductsReturnPage productsReturnPage;
	
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
		productsReturnPage=new ProductsReturnPage(driver);
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
	
	@Test(dataProvider = "db-customer-inputs", dataProviderClass = LoginDataProviders.class)
	public void testToDeleteRetestToDeleteReturnsOfCustomerUsingDB_test(String order_ID,String customer,String first_name,String last_Name,String eMail,String phone,String product,String model) throws InterruptedException {
		System.out.println(order_ID + customer + first_name + last_Name +  eMail +  phone +  product +  model);
		String xpath="//*[@id=\"menu-sale\"]/ul/li";
		DashBoardDetails.OpenSalesIcon();
		Thread.sleep(3000);
		DashBoardDetails.chooseLineItems(xpath, "Returns");
		productsReturnPage.clickToAddNewButton();
		Thread.sleep(3000);
		productsReturnPage.fillInTheMandatoryDetails(order_ID, customer, first_name, last_Name, eMail, phone, product, model);
		productsReturnPage.clickToSaveButton();
		Thread.sleep(3000);
		productsReturnPage.fiterCustomer(customer);
		Thread.sleep(3000);
		productsReturnPage.deleteEntry();
		Thread.sleep(3000);
	}

}
