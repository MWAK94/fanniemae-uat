package com.fanniemae.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			switch (ConfigurationReader.getProperty("browser")) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", ConfigurationReader.getProperty("chrome.driver.path"));
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", ConfigurationReader.getProperty("firefox.driver.path"));
				driver = new FirefoxDriver();
				break;

			default:
				System.setProperty("webdriver.chrome.driver", ConfigurationReader.getProperty("chrome.driver.path"));
				driver = new ChromeDriver();
				break;
			}
		}
		return driver;
	}
	
	public static void closeDriver(){
		if(driver!=null){
			driver.quit();
			driver=null;
		}
	}
}
