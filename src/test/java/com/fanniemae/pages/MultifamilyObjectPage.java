package com.fanniemae.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanniemae.utilities.Driver;

public class MultifamilyObjectPage {
	public MultifamilyObjectPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath= "//nav/ul/li")
	public List<WebElement> allTabs;
}
