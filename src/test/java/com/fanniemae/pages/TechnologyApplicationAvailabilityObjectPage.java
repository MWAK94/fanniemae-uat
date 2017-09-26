package com.fanniemae.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanniemae.utilities.Driver;

public class TechnologyApplicationAvailabilityObjectPage {
	public TechnologyApplicationAvailabilityObjectPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(tagName= "h1")
	public WebElement mainHeader;
	
	@FindBy(xpath= "//div[@class='right-of-flag']/p")
	public WebElement statement;
	
	@FindBy(tagName= "h3")
	public WebElement userHelp;
	
	@FindBy(xpath= "(//header[@class='cp-header']/h3)[2]")
	public WebElement hoursHeader;
}
