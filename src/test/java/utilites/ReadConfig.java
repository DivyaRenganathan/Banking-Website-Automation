package utilites;



import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig(){
		File src=new File("./Configuration/Config.properties");
		try {
			FileInputStream fis =new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		} 
		catch (Exception e)
		{
				System.out.println("Exception is"+e.getMessage());
			}
		} 
	
	public String getUsername() {
		String user = pro.getProperty("Username");
		if(user != null) return user;
		else throw new RuntimeException("Username not specified in the Config.properties file.");
	}
	public String getPassword() {
		String password = pro.getProperty("Password");
		if(password != null) return password;
		else throw new RuntimeException("Username not specified in the Config.properties file.");
	}
	public String getChromeDriverPath(){
		String chromedriverPath = pro.getProperty("chromedriverpath");
		if(chromedriverPath!= null) return chromedriverPath;
		else throw new RuntimeException("driverPath not specified in the Config.properties file.");		
	}
	public String getedgeDriverPath(){
		String edgedriverPath = pro.getProperty("edgedriverpath");
		if(edgedriverPath!= null) return edgedriverPath;
		else throw new RuntimeException("driverPath not specified in the Config.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = pro.getProperty("implicityWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Config.properties file.");		
	}
	
	public String getApplicationUrl() {
		String baseurl = pro.getProperty("baseurl");
		if(baseurl != null) return baseurl;
		else throw new RuntimeException("url not specified in the Config.properties file.");
	}
	public String getRegisterName() {
		String rfname = pro.getProperty("firstname");
		if(rfname != null) return rfname;
		else throw new RuntimeException("firstname not specified in the Config.properties file.");
	}
	public String getRegisterLastName() {
		String lfname = pro.getProperty("lastname");
		if(lfname != null) return lfname;
		else throw new RuntimeException("Lastname not specified in the Config.properties file.");
	}
	public String getRegisterAddress() {
		String radd = pro.getProperty("address");
		if(radd != null) return radd;
		else throw new RuntimeException("Address not specified in the Config.properties file.");
	}
	public String getRegisterState() {
		String rstate = pro.getProperty("state");
		if(rstate != null) return rstate;
		else throw new RuntimeException("State not specified in the Config.properties file.");
	}
	public String getRegisterCity() {
		String rcity = pro.getProperty("city");
		if(rcity != null) return rcity;
		else throw new RuntimeException("City not specified in the Config.properties file.");
	}
	public String getRegisterUser() {
		String ruser = pro.getProperty("regusername");
		if(ruser != null) return ruser;
		else throw new RuntimeException("Register user not specified in the Config.properties file.");
	}
	public String getRegisterPassword() {
		String rpwd = pro.getProperty("regpassword");
		if(rpwd != null) return rpwd;
		else throw new RuntimeException("Register password not specified in the Config.properties file.");
	}

	
}