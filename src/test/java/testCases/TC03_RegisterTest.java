package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterPage;


public class TC03_RegisterTest extends BaseTest{
	@Test	
	public  void RegisterTest() {

/*--------------------------------------------------------------------------------------------------------------------
    						Object for ResgisterPage and Home Page
---------------------------------------------------------------------------------------------------------------------*/
		RegisterPage RegisterPageObj =new RegisterPage(driver);
		HomePage HomePageObj =new HomePage(driver);
/*--------------------------------------------------------------------------------------------------------------------
					Title , Assert and variable declaration and initialization
---------------------------------------------------------------------------------------------------------------------*/
		String Registercheck;
		String AssertRegister="Welcome ";
		String newUser=regusername+getRandomString(4);
		String newPass=regpassword+getRandomString(4);
/*--------------------------------------------------------------------------------------------------------------------
						Invoking Action Methods
---------------------------------------------------------------------------------------------------------------------*/                
		RegisterPageObj.clickRegisterLink();
		logger.info("Register Link has clicked");
		RegisterPageObj.enterFirstName(firstname);
		logger.info("Entered first name");
		RegisterPageObj.enterLastName(lastname);
		logger.info("Entered last name");
		RegisterPageObj.enterAddress(address);
		logger.info("Entered address");
		RegisterPageObj.enterCity(city);
		logger.info("Entered city");
		RegisterPageObj.enterState(state);
		logger.info("Entered state");
		RegisterPageObj.enterzipcode(String.valueOf(getRandomNumber(5)));
		logger.info("Entered zipcode");
		RegisterPageObj.enterPhone(String.valueOf(getRandomNumber(9)));
		logger.info("Entered phonenumber");
		RegisterPageObj.enterSSN(String.valueOf(getRandomNumber(3)));
		logger.info("Entered SSN");
		RegisterPageObj.enterUserName(newUser);
		logger.info("Entered Username");
		RegisterPageObj.enterPassword(newPass);
		logger.info("Entered Password");
		RegisterPageObj.confirmPassword(newPass);
		logger.info("Confirmed Username");
		RegisterPageObj.cLickRegisterButton();
		logger.info("Clicked Register button");
/*-----------------------------------------------------------------------------------------------------------------------
 *                                           Verification
 ---------------------------------------------------------------------------------------------------------------------*/
		Registercheck=HomePageObj.getWelcomeText();
		if(Registercheck.equals(AssertRegister+newUser)) {
			getScreenshot(driver,"RegisterTest");
			logger.info(newUser+"was successfully registerd");
		}
		else {
			getScreenshot(driver,"RegisterTest");
			Assert.assertTrue(false);
			logger.info("TC03_RegisterTest case failed");
			
		}		



}
}
