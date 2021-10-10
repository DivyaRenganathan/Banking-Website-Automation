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
		@FindBy(name="username")
		WebElement username;
		
		
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
		public void ClickUser() {
			username.click();
		}
		
}


