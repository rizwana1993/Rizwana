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
import com.training.pom.EditCustomerPageDetails;
import com.training.pom.LoginPageDetails;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToAddRewardPoints {
	public WebDriver driver;
	public LoginPageDetails LoginPageDetails;
	public DashBoardDetails DashBoardDetails;
	public CustomerGroupPage CustomerGroupPage;
	public CustomerPageDetails CustomerPageDetails;
	public EditCustomerPageDetails EditCustomerPageDetails;
	public AddCustomerDetails AddCustomerDetails;
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
		CustomerPageDetails=new CustomerPageDetails(driver);
		EditCustomerPageDetails=new EditCustomerPageDetails(driver);
		DashBoardDetails=new DashBoardDetails(driver);
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
	public void TestToAddRewardPoints_test() throws InterruptedException {
		//click on Customer icon
		DashBoardDetails.OpenCustomerIcon();
		Thread.sleep(1000);
		//Click on Customers link
		DashBoardDetails.OpenCustomerLink();
		Thread.sleep(1000);
		//click on Edit icon of the Customer
		CustomerPageDetails.EditCustomer1();
		//Enter valid credentials in First Name textbox
		CustomerPageDetails.EditCustomer2("Asmita");
		Thread.sleep(1000);
		CustomerPageDetails.EditCustomer3();
		CustomerPageDetails.EditCustomer4();
		EditCustomerPageDetails.EditCustomerPage1();	
		EditCustomerPageDetails.EditCustomerPage2("Asmita1");
		Thread.sleep(1000);
		//Click on Address1 tab
		EditCustomerPageDetails.EditCustomerPage3();
		EditCustomerPageDetails.EditCustomerPage4();
		//Enter valid credentials in PostCode textbox
		EditCustomerPageDetails.EditCustomerPage5("8796545");
		Thread.sleep(1000);
		//Click on Reward Points tab
		EditCustomerPageDetails.EditCustomerPage6();
		//Enter valid credentials in Description textbox
		EditCustomerPageDetails.EditCustomerPage7("review");
		Thread.sleep(1000);
		//Enter valid credentials in Points textbox
		EditCustomerPageDetails.EditCustomerPage8("50");
		Thread.sleep(1000);
		//click on Add reward Points button
		EditCustomerPageDetails.EditCustomerPage9();
		// Click on Save button
		EditCustomerPageDetails.EditCustomerPage10();
		//Click on Reports icon
		DashBoardDetails.OpenreportLink();
		Thread.sleep(1000);
		//click on Customers link
		DashBoardDetails.OpenCustomerHyperlink();
		Thread.sleep(1000);
		//Click on Reward Points link
		DashBoardDetails.ReportCustomerIcon();
	}
}
