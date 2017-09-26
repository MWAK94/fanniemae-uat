package com.fanniemae.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanniemae.utilities.Driver;

public class LoanDeliveryObjectPage {
	public LoanDeliveryObjectPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath= "//section[@class='cp-section component html']")
	public WebElement header;
}
