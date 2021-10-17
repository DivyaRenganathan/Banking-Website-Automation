package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountOverviewPage {
	 WebDriver driver;
	 WebDriverWait wait=null;
	 int clncount,rowcount;
	 String Account;
     /*--------------------------------------------------------------------------------------------------------------------
                                                      Element identification
     ---------------------------------------------------------------------------------------------------------------------*/
     @FindBy(id="accountTable")
     WebElement accTable;
     
     
     @FindBy(xpath="//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
     WebElement AccountNumber;
     @FindBy(xpath="//*[@id=\"rightPanel\"]/div/div/h1")
     WebElement Overview;
    
     /*--------------------------------------------------------------------------------------------------------------------
                                                          Constructor
     ---------------------------------------------------------------------------------------------------------------------*/
     public AccountOverviewPage(WebDriver driver){
             this.driver =driver;
             PageFactory.initElements(driver,this);
     }
     /*--------------------------------------------------------------------------------------------------------------------
                                                            Action methods
     ---------------------------------------------------------------------------------------------------------------------*/
    public String getAccountNumber(){
    	
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	 WebElement waitelement = wait.until(ExpectedConditions.visibilityOf(accTable));
    	 List<WebElement> cln=waitelement.findElements(By.xpath("//*[@id=\"accountTable\"]/thead/tr/th"));
    	 List<WebElement> row=waitelement.findElements(By.xpath("//*[@id=\"accountTable\"]/tbody/tr"));
    	 clncount =cln.size();
    	 rowcount =row.size();
    	 System.out.println("No:of column"+clncount+"and no:of rows"+rowcount);
    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	 Account=driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr["+rowcount+"]/td[1]")).getText();
    	 return Account;
     }
     public void selectAccount() {
    	AccountNumber.click();	
    	}
     public String getMessage() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 String msg = wait.until(ExpectedConditions.visibilityOf(Overview)).getText();
    	return msg;
     }
    
     
}
