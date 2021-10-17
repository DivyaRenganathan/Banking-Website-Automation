package pageObject;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OpenAccountPage {
	WebDriver driver;
	WebDriverWait wait=null;
    /*--------------------------------------------------------------------------------------------------------------------
                                                     Element identification
    ---------------------------------------------------------------------------------------------------------------------*/
    @FindBy(id="type")
    WebElement AccountType;
    @FindBy(id="fromAccountId")
    WebElement AccountNumber;
    @FindBy(xpath="/html/body/div[1]/div[3]/div[2]/div/div/form/div/input")
    WebElement AccountButton;
    @FindBy(xpath="//*[@id=\"rightPanel\"]/div/div/p[2]/b")
    WebElement AccountOpened;
    @FindBy(xpath="//*[@id=\"newAccountId\"]")
    WebElement NewAccno;
   
    
    /*--------------------------------------------------------------------------------------------------------------------
                                                         Constructor
    ---------------------------------------------------------------------------------------------------------------------*/
    public  OpenAccountPage(WebDriver driver){
            this.driver =driver;
            PageFactory.initElements(driver,this);
    }
    /*--------------------------------------------------------------------------------------------------------------------
                                                           Action methods
    ---------------------------------------------------------------------------------------------------------------------*/
    public void SelectAccountType(String type) {
    	Select dropdown = new Select(AccountType); 
    	dropdown.selectByVisibleText(type);
    	}
    public void SelectAccountNumber() {
    	Select dropdown = new Select(AccountNumber); 
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	dropdown.selectByIndex(0); 
    }
    public void ClickAccountButton() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	 wait.until(ExpectedConditions.visibilityOf(AccountButton)).click();
    	
    }
    public String GetMessage() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 String msg = wait.until(ExpectedConditions.visibilityOf(AccountOpened)).getText();
    	return msg;
    }
    public String GetNewAccno() {
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   	 String acc = wait.until(ExpectedConditions.visibilityOf(NewAccno)).getText();
   	return acc;
   }
}
