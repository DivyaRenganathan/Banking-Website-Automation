package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
		WebDriver driver;
		/*--------------------------------------------------------------------------------------------------------------------
		                                                 Element identification
		---------------------------------------------------------------------------------------------------------------------*/
		@FindBy(linkText="Register")
		WebElement registerLink;
		@FindBy(name="customer.firstName")
		WebElement firstname;
		@FindBy(name="customer.lastName")
		WebElement lastname;
		@FindBy(name="customer.address.street")
		WebElement address;
		@FindBy(name="customer.address.city")
		WebElement city;
		@FindBy(name="customer.address.state")
		WebElement state;
		@FindBy(name="customer.address.zipCode")
		WebElement zcode;
		@FindBy(name="customer.phoneNumber")
		WebElement phone;
		@FindBy(name="customer.ssn")
		WebElement ssn;
		@FindBy(id="customer.username")
		WebElement username;
		@FindBy(id="customer.password")
		WebElement password;
		@FindBy(id="repeatedPassword")
		WebElement confirm;
		@FindBy(xpath="//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
		WebElement RegisterButton;
		
		/*--------------------------------------------------------------------------------------------------------------------
		                                                     Constructor
		---------------------------------------------------------------------------------------------------------------------*/
		public RegisterPage(WebDriver driver){
			this.driver =driver;
			PageFactory.initElements(driver,this);
		}
		/*--------------------------------------------------------------------------------------------------------------------
		                                                       Action methods
		---------------------------------------------------------------------------------------------------------------------*/
		public void clickRegisterLink() {
			 registerLink.click();
		}
		public void enterFirstName(String  fname) {
			firstname.click();
			firstname.sendKeys(fname);
		}
		public void enterLastName(String lname) {
			lastname.click();
			lastname.sendKeys(lname);
		}
		public void enterAddress(String addrs) {
			address.click();
			address.sendKeys(addrs);
		}
		public void enterCity(String pcity) {
			city.click();
			city.sendKeys(pcity);
		}
		public void enterState(String pstate) {
			state.click();
			state.sendKeys(pstate);
		}
		public void enterzipcode(String zip) {
			 zcode.click();
			 zcode.sendKeys(zip);
		}
		public void enterPhone(String phonenum) {
			phone.click();
			phone.sendKeys(phonenum);
		}
		public void enterSSN(String pssn) {
			ssn.click();
			ssn.sendKeys(pssn);
		}
		public void enterUserName(String user) {
			username.click();
			username.sendKeys(user);
		}
		public void enterPassword(String pwd) {
			password.click();
			password.sendKeys(pwd);
		}
		public void confirmPassword(String pwd) {
			 confirm.click();
			 confirm.sendKeys(pwd);
		}
		public void cLickRegisterButton() {
			RegisterButton.click();
		}
		
}


