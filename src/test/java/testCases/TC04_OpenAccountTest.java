package testCases;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.AccountOverviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.OpenAccountPage;

public class TC04_OpenAccountTest extends BaseTest {
	/*--------------------------------------------------------------------------------------------------------------------
	Object for LoginPage and Home Page
---------------------------------------------------------------------------------------------------------------------*/
	LoginPage LoginPageobj= null;
	HomePage HomePageObj =null;
	OpenAccountPage OAPageObj=null;
	AccountOverviewPage AOPageObj=null;
	//WebDriverWait wait=null;
    
	
/*--------------------------------------------------------------------------------------------------------------------
Title and Assert declaration and initialization
---------------------------------------------------------------------------------------------------------------------*/
	String NewAccounttext;
    String AssertNewaccount="Your new account number:"; 
    String NewAcc;
    String overviewAcc;
    
@Test(priority=1)
public void OpenAccountTest() throws IOException {
	LoginPageobj=new LoginPage(driver);
	HomePageObj =new HomePage(driver);
    OAPageObj=new OpenAccountPage(driver); 
	LoginPageobj.ClickUser();
    LoginPageobj.EnterUser(user);
    LoginPageobj.ClickPassword();
    LoginPageobj.EnterPassword(password);
   // System.out.println(password);
    LoginPageobj.clickLogin();
    logger.info("Logged in successfully");
    
    //Click the Open Account Link
    HomePageObj.ClickOpenAccount();
    logger.info("Link clicked successfully");
    OAPageObj.SelectAccountType("SAVINGS");
    logger.info("Account type selected successfully");
	OAPageObj.SelectAccountNumber();
	logger.info("Account Number seclected successfully");
	OAPageObj.ClickAccountButton();
	logger.info("Open Account button clicked  successfully");
	NewAccounttext = OAPageObj.GetMessage();
	System.out.println(NewAccounttext);
	if(AssertNewaccount.equals(NewAccounttext)) {
		assertTrue(true);
		logger.info("TC04_OpenAccountTest passed");
		HomePageObj.ClickLogout();
	}
	else {
		getScreenshot(driver,"OpenAccountTest");
		assertTrue(false);
		logger.warn("TC04_OpenAccountTest failed");
		HomePageObj.ClickLogout();
	}
}


@Parameters("accounttype")
@Test(priority=0)
public void AccountTypeTest(String at) {
	LoginPageobj=new LoginPage(driver);
	HomePageObj =new HomePage(driver);
    OAPageObj=new OpenAccountPage(driver); 
	LoginPageobj.ClickUser();
    LoginPageobj.EnterUser(user);
    LoginPageobj.ClickPassword();
    LoginPageobj.EnterPassword(password);
   // System.out.println(password);
    LoginPageobj.clickLogin();
    logger.info("Logged in successfully");
    
    //Click the Open Account Link
    HomePageObj.ClickOpenAccount();
    logger.info("Link clicked successfully");
    OAPageObj.SelectAccountType(at);
    logger.info("Account type successfully");
	OAPageObj.SelectAccountNumber();
	logger.info("Account Number selected successfully");
	OAPageObj.ClickAccountButton();
	logger.info("Open Account button clicked successfully");
	NewAccounttext = OAPageObj.GetMessage();
	System.out.println(NewAccounttext);
	if(AssertNewaccount.equals(NewAccounttext)) {
		assertTrue(true);
		logger.info("TC04_OpenAccountTest- Account type -passed");
		HomePageObj.ClickLogout();
	}
	else {
		getScreenshot(driver,"AccountTypeTest");
		assertTrue(false);
		logger.warn("TC04_OpenAccountTest- Account type- failed");
		HomePageObj.ClickLogout();
	}
}

@Test(priority=3)
public void AccountNumber_verification() {
	LoginPageobj=new LoginPage(driver);
	HomePageObj =new HomePage(driver);
    OAPageObj=new OpenAccountPage(driver); 
    AOPageObj=new AccountOverviewPage(driver);
	LoginPageobj.ClickUser();
    LoginPageobj.EnterUser(user);
    LoginPageobj.ClickPassword();
    LoginPageobj.EnterPassword(password);
   // System.out.println(password);
    LoginPageobj.clickLogin();
    logger.info("Logged in successfully");
    
    //Click the Open Account Link
    HomePageObj.ClickOpenAccount();
    logger.info("Link clicked successfully");
    //Create a new Account
    OAPageObj.SelectAccountType("SAVINGS");
    logger.info("Account type successfully");
	OAPageObj.SelectAccountNumber();
	logger.info("Account Number selected successfully");
	OAPageObj.ClickAccountButton();
	logger.info("Open Account button clicked successfully");
	NewAcc = OAPageObj.GetNewAccno();
	//Directed to AccountOverview page
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	HomePageObj.AccountOverViewPage();
	//Get the last/newly created  account in Account Table
	overviewAcc= AOPageObj.getAccountNumber();
	System.out.println(NewAcc+"and"+overviewAcc);
	//Verify the newly created account is added to the Account's table
	if(NewAcc.equals(overviewAcc)) {
		assertTrue(true);
		logger.info("TC04_OpenAccountTest-AccountNumber_verification -passed");
		HomePageObj.ClickLogout();
	}
	else {
		getScreenshot(driver,"AccountNumber_verification");
		assertTrue(false);
		logger.warn("TC04_OpenAccountTest-AccountNumber_verification- failed");
		HomePageObj.ClickLogout();
	}
}
}