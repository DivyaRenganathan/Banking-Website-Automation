package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	/*--------------------------------------------------------------------------------------------------------------------
	                                                 Element identification
	---------------------------------------------------------------------------------------------------------------------*/
	@FindBy(linkText="Log Out")
	WebElement LogOutButton;
	
	
	/*--------------------------------------------------------------------------------------------------------------------
	                                                     Constructor
	---------------------------------------------------------------------------------------------------------------------*/
	public HomePage(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	/*--------------------------------------------------------------------------------------------------------------------
	                                                       Action methods
	---------------------------------------------------------------------------------------------------------------------*/
	public void ClickLogout() {
		LogOutButton.click();
	}
}
