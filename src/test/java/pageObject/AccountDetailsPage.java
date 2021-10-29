package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDetailsPage {
	WebDriver driver;
	WebDriverWait wait=null;
    /*--------------------------------------------------------------------------------------------------------------------
                                                     Element identification
    ---------------------------------------------------------------------------------------------------------------------*/
    @FindBy(xpath="//*[@id=\"rightPanel\"]/div/div[1]/h1")
    WebElement Details;
    @FindBy(xpath="//*[@id=\"accountId\"]")
    WebElement AccountNumber;
    @FindBy(id="month")
    WebElement month;
    @FindBy(id="transactionType")
    WebElement tranType;
    @FindBy(xpath="//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input")
    WebElement GoButton;
    @FindBy(xpath="//*[@id=\"transactionTable\"]/tbody/tr/td[1]")
    WebElement date;
    @FindBy(linkText="Funds Transfer Received")
    WebElement fund;
    @FindBy(xpath="//*[@id=\"rightPanel\"]/h1")
    WebElement Transaction;
    /*--------------------------------------------------------------------------------------------------------------------
                                                         Constructor
    ---------------------------------------------------------------------------------------------------------------------*/
    public AccountDetailsPage(WebDriver driver){
            this.driver =driver;
            PageFactory.initElements(driver,this);
    }
    /*--------------------------------------------------------------------------------------------------------------------
                                                           Action methods
    ---------------------------------------------------------------------------------------------------------------------*/
    public String getMessage() {
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   	 String msg = wait.until(ExpectedConditions.visibilityOf(Details)).getText();
   	return msg;
    }
    public void selectMonth() {
     	Select dropdown = new Select(month); 
     	dropdown.selectByIndex(0); 
     }
     public void selectAccountType() {
      	Select dropdown = new Select(tranType); 
      	dropdown.selectByIndex(0); 
      }
     public void clickGo() {
    	 GoButton.click();
     }
     public void clickFundLink() {
    	 fund.click();
     }
     public String transactiontext() {
    	String text= Transaction.getText();
    	return text;
     }
}
