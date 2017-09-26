package com.fanniemae.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanniemae.utilities.Driver;

public class SearchResultsObjectPage {
	public SearchResultsObjectPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath= "//div[@class='p']")
	public WebElement invalidSearchResult;
	
	@FindBy(name= "q")
	public WebElement searchBar;
	
	@FindBy(xpath= "//div[@class='dn-hdr']")
	public WebElement refineSearch;
	
	@FindBy(xpath= "//h3[@class='component-title']")
	public WebElement allResults;
	
	@FindBy(xpath= "//div[@class='results-summary']")
	public WebElement numOfResult;
}
