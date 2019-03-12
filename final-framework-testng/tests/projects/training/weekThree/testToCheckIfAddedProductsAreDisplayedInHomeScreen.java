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
import com.training.pom.LoginPageDetails;
import com.training.pom.*;
import com.training.pom.SalesReportPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class testToCheckIfAddedProductsAreDisplayedInHomeScreen {
	
	private WebDriver driver;
	private LoginPageDetails LoginPageDetails;
	private static Properties properties;
	private DashBoardDetails DashBoardDetails;
    private ProductsPage productsPage;
	
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
		productsPage=new ProductsPage(driver);
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
	public void testToCheckIfAddedProductsAreDisplayedInHomeScreen_test(String productname,String metaTagTitlename,String manufacturername,String model,String price,String qty,String category) throws InterruptedException {
		String xpath="//*[@id=\"menu-catalog\"]/ul/li";
		DashBoardDetails.OpenCatalogueIcon();
		Thread.sleep(3000);
		DashBoardDetails.chooseLineItems(xpath, "Products");
		productsPage.clickToNewButton();
		productsPage.fillGeneralDetails(productname, metaTagTitlename);
		Thread.sleep(1000);
		productsPage.enterDataDetails1();
		//Enter valid credentials in Price textbox
		productsPage.enterDataDetails2(model);
		//Enter valid credentials in Quantity textbox
		productsPage.enterDataDetails3(price);
		//Click on Links tab
		productsPage.enterDataDetails4(qty);
		Thread.sleep(1000);
		productsPage.enterLinkDetails1();
		// Enter valid credentials in Manufacturer textbox
		productsPage.enterLinkDetails2(manufacturername);
		//Select Category from displayed category list
		productsPage.enterLinkDetails3(category);
		Thread.sleep(1000);
		//Keep default values in Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab
		productsPage.clickToAttribute();
		Thread.sleep(1000);
		//Click on Save icon
		productsPage.clickToSaveButton();
		productsPage.logout();
		
	}

}

