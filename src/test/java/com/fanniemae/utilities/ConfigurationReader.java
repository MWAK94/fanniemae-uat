package com.fanniemae.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	private static Properties configFile;
	
	static{
			String path= "./src/test/resources/test_data/configuration.properties";
			
			try {
				FileInputStream input= new FileInputStream(path);
				
				configFile= new Properties();
				configFile.load(input);
				
				input.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static String getProperty(String key){
		return configFile.getProperty(key);
	}
	
	
}
