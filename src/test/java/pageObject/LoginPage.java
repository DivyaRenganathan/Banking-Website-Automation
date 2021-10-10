package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	/*--------------------------------------------------------------------------------------------------------------------
	                                                 Element identification
	---------------------------------------------------------------------------------------------------------------------*/
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/form/div[3]/input")
	WebElement LoginButton;
	/*--------------------------------------------------------------------------------------------------------------------
	                                                     Constructor
	---------------------------------------------------------------------------------------------------------------------*/
	public LoginPage(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	/*--------------------------------------------------------------------------------------------------------------------
	                                                       Action methods
	---------------------------------------------------------------------------------------------------------------------*/
	public void ClickUser() {
		username.click();
	}
	public void ClickPassword() {
		password.click();
	}
	
	public void clickLogin() {
		LoginButton.click();
	}
	public void EnterUser(String user){
		username.sendKeys(user);
	}
	public void EnterPassword(String userpassword) {
		password.sendKeys(userpassword);
	}
}
