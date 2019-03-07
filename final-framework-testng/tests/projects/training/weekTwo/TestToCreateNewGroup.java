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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToCreateNewGroup {
	public WebDriver driver;
	public LoginPageDetails LoginPageDetails;
	public DashBoardDetails DashBoardDetails;
	public CustomerGroupPage CustomerGroupPage;
	public AddCustomerGroup AddCustomerGroup;
	public CustomerPageDetails CustomerPageDetails;
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
		new ScreenShot(driver); 
		DashBoardDetails=new DashBoardDetails(driver);
		CustomerPageDetails=new CustomerPageDetails(driver);
		CustomerGroupPage = new CustomerGroupPage(driver);
		AddCustomerGroup=new AddCustomerGroup(driver);
		AddCustomerDetails=new AddCustomerDetails(driver);
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
	public void TestToCreateNewGroup_test() throws InterruptedException {	
		
		//click on Customer icon
		DashBoardDetails.OpenCustomerIcon();
		Thread.sleep(1000);
		//Click on Customer Groups link
		DashBoardDetails.OpenCustomerGroupLink();
		Thread.sleep(1000);
		//Click on Add New icon
		CustomerGroupPage.CreateCustomerGroup();
		Thread.sleep(1000);
		//Enter valid credentials in Customer Group Name textbox
		AddCustomerGroup.AddCustomerGroupDetails1("privileged customer12");
		Thread.sleep(1000);
		//Enter valid credentials in Description textbox
		AddCustomerGroup.AddCustomerGroupDetails2("privileged customer");
		Thread.sleep(3000);
		//Click yes radio button of Approve New Customers section
		AddCustomerGroup.AddCustomerGroupDetails3();
		Thread.sleep(1000);
		//Click on Save button
		AddCustomerGroup.AddCustomerGroupDetails4();
		Thread.sleep(1000);
		//click on Customer icon
		DashBoardDetails.OpenCustomerIcon();
		Thread.sleep(1000);
		//Click on Customers link
		DashBoardDetails.OpenCustomerLink();
		Thread.sleep(1000);
		//Click on Add new icon
		CustomerPageDetails.AddNewCustomer();
		//Select valid credentials in Customer group list box
		AddCustomerDetails.AddCustomerDetails1("privileged customer12");
		Thread.sleep(1000);
		//Enter valid credentials in First Name textbox
		AddCustomerDetails.AddCustomerDetails2("Manzoor");
		Thread.sleep(1000);
		//Enter valid credentials in last Name textbox
		AddCustomerDetails.AddCustomerDetails3("Mehadi");
		Thread.sleep(1000);
		//Enter valid credentials in E-Mail textbox
		AddCustomerDetails.AddCustomerDetails4("manzoor@gmail.com");
		Thread.sleep(1000);
		//Enter valid credentials in Telephone textbox
		AddCustomerDetails.AddCustomerDetails5("9876543210");
		Thread.sleep(1000);
		//Enter valid credentials in Password textbox
		AddCustomerDetails.AddCustomerDetails6("manzoor1");
		Thread.sleep(1000);
		//Enter valid credentials in Confirm password textbox
		AddCustomerDetails.AddCustomerDetails7("manzoor1");
		Thread.sleep(1000);
		//Click on Address1 tab
		AddCustomerDetails.AddCustomerDetails8();
		Thread.sleep(1000);
		AddCustomerDetails.AddCustomerDetails9("Manzoor");
		Thread.sleep(1000);
		AddCustomerDetails.AddCustomerDetails10("Mehadi");
		Thread.sleep(1000);
		//Enter valid credentials in Address1 textbox
		AddCustomerDetails.AddCustomerDetails11("yeshwanthapur");
		Thread.sleep(1000);
		//Enter valid credentials in Address2 textbox
		AddCustomerDetails.AddCustomerDetails12("bangalore");
		Thread.sleep(1000);
		//Enter valid credentials in City textbox
		AddCustomerDetails.AddCustomerDetails13("bangalore");
		Thread.sleep(1000);
		//Enter valid credentials in Post Code textbox
		AddCustomerDetails.AddCustomerDetails14("560022");
		Thread.sleep(1000);
		//Select credentials from Country list box
		AddCustomerDetails.AddCustomerDetails15("India");
		Thread.sleep(1000);
		//Select credentials from Region/State list box
		AddCustomerDetails.AddCustomerDetails16("Karnataka");
		Thread.sleep(1000);
		//Click on save icon
		AddCustomerDetails.AddCustomerDetails17();	
		
	}
	

}
