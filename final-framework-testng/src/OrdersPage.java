import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	private WebDriver driver;


	public OrdersPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement addNewButton;
	
	@FindBy(name="customer")
	private WebElement customerName;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement emailId;
	
	@FindBy(name="telephone")
	private WebElement telephoneNumber;

	@FindBy(name="button-customer")
	private WebElement continueButton;
	
	@FindBy(name="product")
	private WebElement productName;
	
	@FindBy(name="quantity")
	private WebElement quantityNumbers;
	
	@FindBy(id="button-product-add")
	private WebElement addProductButton;
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	private WebElement continueButtonInProductsTab;
	
	@FindBy(xpath="//*[@id=\"input-payment-address\"]")
	private WebElement addressInput;
	
	@FindBy(name="address_1")
	private WebElement address1Input;
	
	@FindBy(name="city")
	private WebElement cityName;
	
	@FindBy(xpath="//*[@id=\"input-payment-country\"]")
	private WebElement countryInput;
	
	@FindBy(name="zone_id")
	private WebElement region;
	
	@FindBy(xpath="//*[@id=\"button-payment-address\"]")
	private WebElement continueButtonInPaymentsPage;
	
	@FindBy(xpath="//*[@id=\"button-shipping-address\"]")
	private WebElement ContinueButtonInShippingPage;
	
	@FindBy(xpath="//*[@id=\"input-shipping-method\"]")
	private WebElement shippingMethod;
	
	@FindBy(xpath="//*[@id=\"input-payment-method\"]")
	private WebElement paymentMethodInput;
	
	@FindBy(xpath="button-shipping-method")
	private WebElement shippingApply;
	
	@FindBy(xpath="button-paymethod-method")
	private WebElement paymentApply;
	
	@FindBy(id="button-save")
	private WebElement saveButton;
	
	public void clickOnNewButton() {
		addNewButton.click();
	}
	
	public void selectvalue(WebElement webelement,String StringToCompare) {
		List<WebElement> values=webelement.findElements(By.tagName("option"));
		int size=values.size();
		System.out.println(size);
		
		for(int i=0;i<size;i++) {	
			String answer[]=new String[size];
			answer[i]=values.get(i).getText();	
			if(answer[i].equals(StringToCompare)){
				values.get(i).click();
			}
			
			
		}
		
	}
	
	public void fillCustomerDetails(String customername,String firstname,String lastname, String email,String telephone) {
		customerName.sendKeys(customername);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		emailId.sendKeys(email);
		telephoneNumber.sendKeys(telephone);
		continueButton.click();
	}
	
	public void fillProductDetails(String productname,String numbers) {
		productName.sendKeys(productname);
		quantityNumbers.sendKeys(numbers);
		addProductButton.click();
		continueButtonInProductsTab.click();
		
		
	}
	
	public void fillPaymentDetails(String firstname,String lastname,String address1,String city,String country,String state) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		address1Input.sendKeys(address1);
		cityName.sendKeys(city);
		selectvalue(countryInput,country);
		selectvalue(region,state);
		continueButtonInPaymentsPage.click();
	}
	
	public void fillShippingDetails(String firstname,String lastname,String address1,String city,String country,String state) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		address1Input.sendKeys(address1);
		cityName.sendKeys(city);
		selectvalue(countryInput,country);
		selectvalue(region,state);
		ContinueButtonInShippingPage.click();
	}
	
	
	public void fillTotalsPageDetails(String paymentMethod) {
		selectvalue(shippingMethod,"Free Shipping - Rs.0");
		shippingApply.click();
		selectvalue(paymentMethodInput,paymentMethod);
		paymentApply.click();
		saveButton.click();		
	}
	
}

