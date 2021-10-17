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
	@FindBy(linkText="Open New Account")
	WebElement OpenAcc;
	@FindBy(linkText="Accounts Overview")
	WebElement Overview;
	@FindBy(linkText="Transfer Funds")
	WebElement Transfer;
	@FindBy(linkText="Bill Pay")
	WebElement Bill;
	@FindBy(linkText="Find Transactions")
	WebElement Transaction;
	@FindBy(linkText="Update Contact Info")
	WebElement contact;
	@FindBy(linkText="Request Loan")
	WebElement Loan;
	@FindBy(linkText="Log Out")
	WebElement LogOutButton;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/h1")
	WebElement WelcomeText;
	
	
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
	
	public String getWelcomeText() {
		String wtext =WelcomeText.getText();
		return wtext;
	}
	public void ClickOpenAccount() {
		OpenAcc.click();
	}
	public void AccountOverViewPage() {
		 Overview.click();
	}
}
