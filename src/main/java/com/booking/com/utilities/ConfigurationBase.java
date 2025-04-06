package com.booking.com.utilities;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationBase {
	
	private static Properties prop = new Properties();
	
	public void loadProperties() {
		
		try {
			prop.load(getClass().getResourceAsStream("/config.properties"));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String propname)
	{
		return prop.getProperty(propname);
	}
 }
