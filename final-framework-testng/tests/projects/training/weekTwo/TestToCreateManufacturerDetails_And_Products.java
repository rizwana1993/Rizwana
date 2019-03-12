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
import com.training.pom.ProductsPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestToCreateManufacturerDetails_And_Products {
	public WebDriver driver;
	public LoginPageDetails LoginPageDetails;
	public DashBoardDetails DashBoardDetails;
	public CustomerGroupPage CustomerGroupPage;
	public CustomerPageDetails CustomerPageDetails;
	public EditCustomerPageDetails EditCustomerPageDetails;
	public AddCustomerDetails AddCustomerDetails;
	private static Properties properties;
	private ManufacturersPage ManufacturersPage;
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
		ManufacturersPage=new ManufacturersPage(driver);
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
	public void TestToCreateManufacturerDetails_And_Products_test() throws InterruptedException {
		String manufacturername="Rizwana1";
		//Click on Catelog icon
		DashBoardDetails.OpenCatalogueIcon();
		Thread.sleep(1000);
		//Click on Manufacturers link
		DashBoardDetails.OpenManufacturersLink();
		Thread.sleep(1000);
		//Click on Add new icon
		ManufacturersPage.addNewManufacturer1();
		Thread.sleep(1000);
		//Enter valid credentials in Manufacturer name textbox
		ManufacturersPage.addNewManufacturer2(manufacturername);
		Thread.sleep(1000);
		//Click on Save icon
		ManufacturersPage.addNewManufacturer3();
		Thread.sleep(3000);
		//Click on Catelog icon
		DashBoardDetails.OpenCatalogueIcon();
		Thread.sleep(1000);
		//Click on Products link
		DashBoardDetails.OpenProductsLink();
		Thread.sleep(1000);
		//Click on Add New icon
		ProductsPage.clickToNewButton();
		Thread.sleep(1000);
		//Enter Valid credentials in Product Name of General tab
		ProductsPage.fillGeneralDetails("NewProduct", "NewProductMegaTitle");
		Thread.sleep(1000);
		ProductsPage.enterDataDetails1();
		//Enter valid credentials in Price textbox
		ProductsPage.enterDataDetails2(manufacturername);
		//Enter valid credentials in Quantity textbox
		ProductsPage.enterDataDetails3(null);
		//Click on Links tab
		ProductsPage.enterDataDetails4(manufacturername);
		Thread.sleep(1000);
		ProductsPage.enterLinkDetails1();
		// Enter valid credentials in Manufacturer textbox
		ProductsPage.enterLinkDetails2(manufacturername);
		//Select Category from displayed category list
		ProductsPage.enterLinkDetails3(manufacturername);
		Thread.sleep(1000);
		//Keep default values in Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab
		ProductsPage.clickToAttribute();
		Thread.sleep(1000);
		//Click on Save icon
		ProductsPage.clickToSaveButton();
	}
}