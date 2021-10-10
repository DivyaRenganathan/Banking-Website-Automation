package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;



public class TC01_LoginTest extends BaseTest {
	
	
	@Test
	public  void LoginTest() {
		
		//Object for LoginPage
		LoginPage LoginPageobj=new LoginPage(driver);
		HomePage HomePageObj =new HomePage(driver);
		//Title  and AssetText
		String title;
		String AssertLogin="ParaBank | Accounts Overview";
		LoginPageobj.ClickUser();
		logger.info("Clicked username");
		LoginPageobj.EnterUser(user);
		logger.info("Clicked password");
		LoginPageobj.ClickPassword();
		LoginPageobj.EnterPassword(password);
		LoginPageobj.clickLogin();
		title=driver.getTitle();
		if(title.equals(AssertLogin))
		{
			logger.info("test case passed");
			Assert.assertTrue(true);
			HomePageObj.ClickLogout();
		}
		
		else {
			
			getScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
	}
}
