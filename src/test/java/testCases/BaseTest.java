package testCases;


import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilites.ReadConfig;


public class BaseTest {
	
	ReadConfig readconfigobj =new ReadConfig();
	public static WebDriver driver=null;
	String baseurl = readconfigobj.getApplicationUrl();
	String user =readconfigobj.getUsername();
	String password =readconfigobj.getPassword();
	long implicitywait =readconfigobj.getImplicitlyWait();
	//public String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	//Log4j
	public static Logger logger;
	   
	  
	
	@Parameters("browser")
	@BeforeTest
	public  void setUpTest(String br) {
		
		logger = LogManager.getLogger("testCases");
		//System property
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfigobj.getChromeDriverPath());                        
		driver=new ChromeDriver();
		}
		if(br.equals("edge")) {
		System.setProperty("webdriver.edge.driver",readconfigobj.getedgeDriverPath());                        
		driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(readconfigobj.getImplicitlyWait(),TimeUnit.SECONDS);
		driver.get(baseurl);	
		driver.manage().window().maximize();

	}
	@AfterTest
	public  void tearDownTest() {
		System.out.println("Test completed");
		driver.close();
		driver.quit();
	}
	
	public void getScreenshot(WebDriver driver,String testcase) {
		 File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // capture screenshot file
		   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testcase+".png");
		   try{
			   FileUtils.copyFile(source,target);
		   }
		   catch(IOException e){
			   logger.info("File not found exception occurred while taking screenshot " + e.getMessage());
		   }
		   
		   System.out.println("screenshot captured");
	}
	
	
}
