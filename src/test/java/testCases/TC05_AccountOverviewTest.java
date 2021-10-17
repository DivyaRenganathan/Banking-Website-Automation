package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObject.AccountOverviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;


public class TC05_AccountOverviewTest extends BaseTest  {
/*--------------------------------------------------------------------------------------------------------------------
    Object for LoginPage and Home Page
---------------------------------------------------------------------------------------------------------------------*/
	LoginPage LoginPageobj=null;
	HomePage HomePageObj =null;
	AccountOverviewPage AOPageObj=null;
/*--------------------------------------------------------------------------------------------------------------------
          Title and Assert declaration and initialization
---------------------------------------------------------------------------------------------------------------------*/
	String Message;
	String AssertOverview="Accounts Overview";
/*--------------------------------------------------------------------------------------------------------------------
                     Invoking Action Methods
----------------------------------------------------*/
	@Test
	public void AccountOverViewTest() {
		 LoginPageobj=new LoginPage(driver);
	     HomePageObj =new HomePage(driver);
	    AOPageObj=new AccountOverviewPage(driver);
		LoginPageobj.ClickUser();
	    LoginPageobj.EnterUser(user);
	    LoginPageobj.ClickPassword();
	    LoginPageobj.EnterPassword(password);
	   // System.out.println(password);
	    LoginPageobj.clickLogin();
	    logger.info("Logged in successfully");
		HomePageObj.AccountOverViewPage();
		AOPageObj.selectAccount();
		Message =AOPageObj.getMessage();
		if(Message.equals(AssertOverview)) {
			assertTrue(true);
			logger.info("TC05_AccountOverviewTest Case Passed");
		}
		else {
			getScreenshot(driver,"AccountNumber_verification");
			assertTrue(false);
			logger.info("TC05_AccountOverviewTest Case failed");
		}
		
	}
}
