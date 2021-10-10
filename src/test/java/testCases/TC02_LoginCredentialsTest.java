package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import utilites.XLUtils;

public class TC02_LoginCredentialsTest extends BaseTest {
	@Test(dataProvider="Credential")
	public  void LoginCredentialsTest(String user,String password) throws InterruptedException {
		
/*--------------------------------------------------------------------------------------------------------------------
                                  Object for LoginPage and Home Page
---------------------------------------------------------------------------------------------------------------------*/
		LoginPage LoginPageobj=new LoginPage(driver);
		HomePage HomePageObj =new HomePage(driver);
/*--------------------------------------------------------------------------------------------------------------------
        Title and Assert declaration and initialization
---------------------------------------------------------------------------------------------------------------------*/
		String title;
		String AssertLogin="ParaBank | Accounts Overview";
/*--------------------------------------------------------------------------------------------------------------------
        Invoking Action Methods
---------------------------------------------------------------------------------------------------------------------*/		
		LoginPageobj.ClickUser();
		logger.info("Clicked username");
		LoginPageobj.EnterUser(user);
		logger.info("Clicked password");
		LoginPageobj.ClickPassword();
		LoginPageobj.EnterPassword(password);
		LoginPageobj.clickLogin();
		Thread.sleep(3000);
		title=driver.getTitle();
		if(title.equals(AssertLogin))
		{
			logger.info("TC02_LoginCredentialsTest testcase passed");
			Assert.assertTrue(true);
			HomePageObj.ClickLogout();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
		}
		
		else {
			Thread.sleep(3000);
			getScreenshot(driver,"LoginCredentialsTest");
			Assert.assertTrue(false);
			logger.warn("TC02_LoginCredentialsTest testcase failed");
		}
	}
/*--------------------------------------------------------------------------------------------------------------------
    DataProvider method to get data from excel file in the testData Package
---------------------------------------------------------------------------------------------------------------------*/
	@DataProvider(name="Credential")
	public String[][] getTestData() throws IOException{
			String path=System.getProperty("user.dir")+"/src/test/java/testData/BankingWebautomation User_password details.xlsx";
			
				int rowcount = XLUtils.getRowCount(path,"Sheet1");
				int columncount =XLUtils.getCellCount(path,"Sheet1", 1);
				String logincredential[][] =new String [rowcount][columncount];
			
				for(int i=1;i<=rowcount;i++) {
					
					for (int j=0;j<columncount;j++) {
						
						logincredential[i-1][j]= XLUtils.getCellData(path,"Sheet1", i, j);
					}	
			   }
			return logincredential;
	}

}
