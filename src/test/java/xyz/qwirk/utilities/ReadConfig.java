package xyz.qwirk.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Resources/Import/Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is"+e.getMessage());
			e.printStackTrace();
		}
				
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String url = pro.getProperty("cUserName");
		return url;
	}
	
	public String getPassword() {
		String url = pro.getProperty("cPassword");
		return url;
	}
	
	public String getChromePath() {
		String url = pro.getProperty("chromepath");
		return url;
	}
	public String getFireFoxPath() {
		String url = pro.getProperty("firefoxpath");
		return url;
	}
	public String getIEPath() {
		String url = pro.getProperty("iepath");
		return url;
	}
	
}
