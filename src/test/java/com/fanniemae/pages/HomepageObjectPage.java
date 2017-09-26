package com.fanniemae.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanniemae.utilities.Driver;

public class HomepageObjectPage {
	public HomepageObjectPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id= "uz_span_close")
	public WebElement close;
	
	@FindBy(xpath= "//a[@class='logo']")
	public WebElement logo;
	
	@FindBy(id= "instantSearch")
	public WebElement searchBox;
	
	@FindBy(xpath= "//input[@type='submit']")
	public WebElement searchIcon;
	
	@FindBy(linkText= "Login")
	public WebElement loginbutton;
	
	@FindBy(linkText= "Single-Family")
	public WebElement snigleFamilLink;
	
	@FindBy(linkText= "Multifamily")
	public WebElement multiFamilyLink;
	
	@FindBy(xpath= "//img[@class='flag']")
	public WebElement image;
	
	@FindBy(xpath= "//h1")
	public WebElement PEtext;
	
	@FindBy(xpath= "//div[@id='region-header']//span")
	public WebElement paragraph;
	
	@FindBy(xpath= "//a[@class='launch-app']")
	public WebElement launchApp;
	
	@FindBy(id= "expand-collapse-header1")
	public WebElement myAccount;
	
	@FindBy(xpath= "//div[@class='ec-plus-minus']")
	public WebElement dropdownListButton;
	
	@FindBy(xpath= "//div[@id='ec_toggle1']/p")
	public WebElement dropdownText;
	
	@FindBy(xpath= "//section/p")
	public List<WebElement> mainRows;
	
	@FindBy(xpath= "//h3")
	public WebElement seeAvalibility;
	
	@FindBy(linkText= "Technology Application Availability")
	public WebElement technologyApplicationLink;
	
	@FindBy(xpath= "//h4[contains(.,'Book')]")
	public WebElement bookmarking;
	
	@FindBy(linkText= "Bookmarking Best Practices")
	public WebElement bookmarkingLink;
	
	@FindBy(xpath= "//section[@class='cp-section component short button subdued']")
	public WebElement relatedSection;
}
