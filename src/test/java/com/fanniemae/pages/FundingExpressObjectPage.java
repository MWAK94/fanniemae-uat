package com.fanniemae.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanniemae.utilities.Driver;

public class FundingExpressObjectPage {
	public FundingExpressObjectPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(tagName= "h1")
	public WebElement header;
}
