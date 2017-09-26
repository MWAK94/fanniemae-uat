package com.fanniemae.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fanniemae.pages.HomepageObjectPage;

public class BrowserUtilities {
	static HomepageObjectPage homePage = new HomepageObjectPage();

	public static void popUpsDissmis() {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
			wait.until(ExpectedConditions.visibilityOf(homePage.close));
			homePage.close.click();
		} catch (Exception e) {
			System.out.println("No pop up this time");
		}
	}
	
	public static List<String> getUncommonListsElement(List<String> a, List<String>b){
		List<String> diff= new ArrayList<>();
    	for(String s: a){
    		if(!b.contains(s)){
    			diff.add(s);
    		}
    	}
    	return diff;
	}
	
	public static void switchTab(String url){
		String defaultTab= Driver.getDriver().getWindowHandle();
		for(String windowHandle: Driver.getDriver().getWindowHandles()){
			Driver.getDriver().switchTo().window(windowHandle);
			if(Driver.getDriver().getCurrentUrl().contains(url)){
				return;
			}
		}
		Driver.getDriver().switchTo().window(defaultTab);
	}
}
