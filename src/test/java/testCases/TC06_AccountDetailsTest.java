package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObject.AccountDetailsPage;
import pageObject.AccountOverviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;


public class TC06_AccountDetailsTest extends BaseTest {
/*--------------------------------------------------------------------------------------------------------------------
    Object for LoginPage and Home Page
---------------------------------------------------------------------------------------------------------------------*/
	LoginPage LoginPageobj=null;
	HomePage HomePageObj =null;
	AccountOverviewPage AOPageObj=null;
	AccountDetailsPage ADPageObj=null;
/*--------------------------------------------------------------------------------------------------------------------
Title and Assert declaration and initialization
---------------------------------------------------------------------------------------------------------------------*/
	String title;
	String AssertLogin="ParaBank | Accounts Overview";
	String AssertTran="Transaction Details";
/*--------------------------------------------------------------------------------------------------------------------
Invoking Action Methods
---------------------------------------------------------------------------------------------------------------------*/                
@Test
	public void AccountDetailsTest() {
	 LoginPageobj=new LoginPage(driver);
	 HomePageObj =new HomePage(driver);
	 AOPageObj=new AccountOverviewPage(driver);
	 ADPageObj=new AccountDetailsPage(driver);
	 //Login
	 LoginPageobj.ClickUser();
	 LoginPageobj.EnterUser(user);
	 LoginPageobj.ClickPassword();
	 LoginPageobj.EnterPassword(password);
	 LoginPageobj.clickLogin();
	 logger.info("Logged in successfully");
	 //Account Details page -select a account
	 AOPageObj.selectAccount();
	 //Select Month and type
	 ADPageObj.selectMonth();
	 logger.info("Month selected successfully");
	 ADPageObj.selectAccountType();
	 logger.info("AccountType successfully");
	 ADPageObj.clickGo();
	 logger.info("Clicked Go Button successfully");
	 ADPageObj.clickFundLink();
	 logger.info("Fund Transaction selected successfully");
	 if(ADPageObj.transactiontext().equals(AssertTran)) {
		 assertTrue(true);
			logger.info("TC06_AccountDetailsTest Case Passed");
		}
		else {
			getScreenshot(driver,"AccountDetailsTest");
			assertTrue(false);
			logger.info("TC06_AccountDetailsTest Case failed");
		}
	 }
	 
 }

