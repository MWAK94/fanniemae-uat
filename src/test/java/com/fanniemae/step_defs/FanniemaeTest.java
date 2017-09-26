package com.fanniemae.step_defs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fanniemae.pages.FundingExpressObjectPage;
import com.fanniemae.pages.HomepageObjectPage;
import com.fanniemae.pages.LoanDeliveryObjectPage;
import com.fanniemae.pages.MultifamilyObjectPage;
import com.fanniemae.pages.SearchResultsObjectPage;
import com.fanniemae.pages.SingleFamilyObjectPage;
import com.fanniemae.pages.TechnologyApplicationAvailabilityObjectPage;
import com.fanniemae.utilities.BrowserUtilities;
import com.fanniemae.utilities.ConfigurationReader;
import com.fanniemae.utilities.Driver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FanniemaeTest {
	HomepageObjectPage homePage = new HomepageObjectPage();
	SearchResultsObjectPage searchPage = new SearchResultsObjectPage();
	String filePath = "./src/test/resources/test_data/FanniemaTestCase.xlsx";

	
	@Given("^on fanniemae webpage$")
	public void on_fanniemae_webpage() throws Throwable {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		BrowserUtilities.popUpsDissmis();
		Driver.getDriver().manage().window().maximize();
	}

	@And("^you verify the title to be \"([^\"]*)\"$")
	public void you_verify_the_title_to_be(String arg1) throws Throwable {
		String title = Driver.getDriver().getTitle();
		Assert.assertEquals(arg1, title);
	}

	@Then("^then the logo with the link \"([^\"]*)\" should be displayed$")
	public void then_the_logo_with_the_link_should_be_displayed(String arg1) throws Throwable {
		Assert.assertTrue(homePage.logo.isDisplayed());
		Assert.assertEquals(arg1, homePage.logo.getAttribute("href").toString());
	}

	@And("^search box should have \"([^\"]*)\" displayed$")
	public void search_box_should_have_displayed(String arg1) throws Throwable {
		String placeHolder = homePage.searchBox.getAttribute("placeholder");
		Assert.assertEquals(arg1, placeHolder);
	}

	@And("^search for something unrelated to mortage example \"([^\"]*)\"$")
	public void search_for_something_unrelated_to_mortage_example(String arg1) throws Throwable {
		homePage.searchBox.sendKeys(arg1 + Keys.ENTER);
	}

	@Then("^you should get No page found containing \"([^\"]*)\" or \"([^\"]*)\"$")
	public void you_should_get_No_page_found_containing_or(String arg1, String arg2) throws Throwable {
		Assert.assertTrue(searchPage.invalidSearchResult.getText().contains(arg2));
	}

	@And("^search for something related example \"([^\"]*)\"$")
	public void search_for_something_related_example(String arg1) throws Throwable {
		searchPage.searchBar.clear();
		searchPage.searchBar.sendKeys(arg1 + Keys.ENTER);
	}

	@Then("^a table on the mid left with \"([^\"]*)\" text should be displayed and another showing \"([^\"]*)\" and the number of results and total number$")
	public void a_table_on_the_mid_left_with_text_should_be_displayed_and_another_showing_and_the_number_of_results_and_total_number(
			String arg1, String arg2) throws Throwable {
		Assert.assertTrue(searchPage.refineSearch.getText().contains(arg1));
		Assert.assertTrue(searchPage.allResults.getText().contains(arg2));
		String result = searchPage.numOfResult.getText();
		//System.out.println(result);
		String[] arrResult = result.split(" ");
		String numOfResult = arrResult[1] + " - " + arrResult[3];
		String totalResult = arrResult[6];
		System.out.println("Number of rsults: "+numOfResult);
		System.out.println("Total results: "+totalResult);
	}
//--------------------------------------------------------------------------------------------------------
	
	@Given("^the search icon button is displayed$")
	public void the_search_icon_button_is_displayed() throws Throwable {
		Assert.assertTrue(homePage.searchIcon.isDisplayed());
	}

	@Given("^the login button is displayed$")
	public void the_login_button_is_displayed() throws Throwable {
		Assert.assertTrue(homePage.loginbutton.isDisplayed());
	}

	@Given("^Single-Family drop down list with Mutilfamily text is displayed$")
	public void single_Family_drop_down_list_with_Mutilfamily_text_is_displayed() throws Throwable {
		Assert.assertTrue(homePage.snigleFamilLink.isDisplayed());
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(homePage.snigleFamilLink).perform();
		Assert.assertTrue(homePage.multiFamilyLink.isDisplayed());
	}

	@Given("^by clicking on the Single-Family link, the title should be \"([^\"]*)\"$")
	public void by_clicking_on_the_Single_Family_link_the_title_should_be(String arg1) throws Throwable {
		homePage.snigleFamilLink.click();
		Assert.assertEquals(arg1, Driver.getDriver().getTitle());
	}

	@Then("^these tabs should be present next to it$")
	public void these_tabs_present_next_to_it(List<String> tabs) throws Throwable {
		SingleFamilyObjectPage singleFamily = new SingleFamilyObjectPage();
		List<String> actualTabs = new ArrayList<>();
		for (WebElement element : singleFamily.alltabs) {
			actualTabs.add(element.getText());
		}
		if (actualTabs.containsAll(tabs)) {
			System.out.println("Tabs Present");
		} else {
			List<String> diff = BrowserUtilities.getUncommonListsElement(tabs, actualTabs);
			System.out.println("Tabs not Present: " + diff);
		}
	}

	@Given("^by clicking on the Mutilfamily Mutilfamily link, the title should be \"([^\"]*)\"$")
	public void by_clicking_on_the_Mutilfamily_Mutilfamily_link_the_title_should_be(String arg1) throws Throwable {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(homePage.snigleFamilLink).perform();
		homePage.multiFamilyLink.click();
		Assert.assertEquals(arg1, Driver.getDriver().getTitle());
	}

	@Then("^these tabs should be present$")
	public void these_tabs_present(List<String> tabs) throws Throwable {
		MultifamilyObjectPage multifamily = new MultifamilyObjectPage();
		List<String> actualTabs = new ArrayList<>();
		for (WebElement element : multifamily.allTabs) {
			actualTabs.add(element.getText());
		}
		if (actualTabs.containsAll(tabs)) {
			System.out.println("Tabs Present");
		} else {
			List<String> diff = BrowserUtilities.getUncommonListsElement(tabs, actualTabs);
			System.out.println("Tabs not Present: " + diff);
		}
	}
	//--------------------------------------------------------------------------------------------------------
	
	@Given("^a image with \"([^\"]*)\" text$")
	public void a_image_with_text(String arg1) throws Throwable {
		Assert.assertEquals(arg1, homePage.PEtext.getText());
	}

	@Given("^next to it this paragrahaph \"([^\"]*)\"$")
	public void next_to_it_this_paragrahaph(String arg1) throws Throwable {
		if (arg1.equals(homePage.paragraph.getText())) {
			return;
		} else {
			System.out.println("-----------------");
		}
	}

	@Given("^a tab Launch App that will take us to a link to login \"([^\"]*)\"$")
	public void a_tab_Launch_App_that_will_take_us_to_link_to_login(String arg1) throws Throwable {
		homePage.launchApp.click();
		BrowserUtilities.switchTab("WebApp");
		Assert.assertEquals(arg1, Driver.getDriver().getCurrentUrl());
	}
//--------------------------------------------------------------------------------------------------------
	
	@Given("^under Launch App button we should have a Manage My account tab with three main rows$")
	public void under_Launch_App_button_we_should_have_a_Manage_My_account_tab_with_three_main_row(List<String> arg1)
			throws Throwable {
		List<String> actualTabs = new ArrayList<>();
		for (WebElement element : homePage.mainRows) {
			actualTabs.add(element.getText());
		}
		if (actualTabs.containsAll(arg1)) {
			System.out.println("Present");
		} else {
			List<String> diff = BrowserUtilities.getUncommonListsElement(arg1, actualTabs);
			System.out.println("rows not present: " + diff);
		}
	}

	@Given("^we should have a button that when we click should give us a drop down list with text \"([^\"]*)\"$")
	public void we_should_have_a_button_that_when_we_click_should_give_us_a_drop_down_list_with_text(String arg1)
			throws Throwable {
		homePage.dropdownListButton.click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(homePage.dropdownText));
		Assert.assertEquals(arg1, homePage.dropdownText.getText());
	}

	@Given("^another tab with \"([^\"]*)\" text and a sentence \"([^\"]*)\"$")
	public void another_tab_with_text_and_a_sentence(String arg1, String arg2) throws Throwable {
		if(arg1.equals(homePage.seeAvalibility.getText())){
			System.out.println("text match");
		}else{
			System.out.println("text: " +arg1+ " did not match");
		}
		
		Assert.assertEquals(arg2, homePage.technologyApplicationLink.getText());
	}

	@Given("^when clicking it it should take us to this page \"([^\"]*)\"$")
	public void when_clicking_it_it_should_take_us_to_this_page(String arg1) throws Throwable {
		homePage.technologyApplicationLink.click();
		Assert.assertEquals(arg1, Driver.getDriver().getCurrentUrl());
	}

	@Given("^Under this page we should have the same logo as the main page$")
	public void under_this_page_we_should_have_the_same_logo_as_the_main_page() throws Throwable {
		Assert.assertTrue(homePage.logo.isDisplayed());
	}

	@Given("^we will have \"([^\"]*)\" and this statement next to it \"([^\"]*)\"$")
	public void we_will_have_and_this_statement_next_to_it(String arg1, String arg2) throws Throwable {
		TechnologyApplicationAvailabilityObjectPage appPage= new TechnologyApplicationAvailabilityObjectPage();
		Assert.assertEquals(arg1, appPage.mainHeader.getText());
		Assert.assertEquals(arg2, appPage.statement.getText());
	}

	@Given("^on the left side we should have \"([^\"]*)\"$")
	public void on_the_left_side_we_should_have(String arg1) throws Throwable {
		TechnologyApplicationAvailabilityObjectPage appPage= new TechnologyApplicationAvailabilityObjectPage();
		Assert.assertTrue(appPage.userHelp.isDisplayed());
		Assert.assertEquals(arg1, appPage.userHelp.getText());
	}

	@Given("^on the left side we will have a tab that says \"([^\"]*)\"$")
	public void on_the_left_side_we_will_have_a_tab_that_says(String arg1) throws Throwable {
		TechnologyApplicationAvailabilityObjectPage appPage= new TechnologyApplicationAvailabilityObjectPage();
		Assert.assertEquals(arg1, appPage.hoursHeader.getText());
	}
	//--------------------------------------------------------------------------------------------------------
	
	@Given("^we have another tab that says \"([^\"]*)\" and under it a link text that says \"([^\"]*)\"$")
	public void we_have_another_tab_that_says_and_under_it_a_link_text_that_says(String arg1, String arg2)throws Throwable {
		Assert.assertEquals(arg1, homePage.bookmarking.getText());
		Assert.assertEquals(arg2, homePage.bookmarkingLink.getText());
	}

	@Given("^another tab that says \"([^\"]*)\"$")
	public void another_tab_that_says(String arg1) throws Throwable {
		List<WebElement> headers= homePage.relatedSection.findElements(By.tagName("h3"));
		String header= headers.get(0).getText();
		Assert.assertEquals(arg1, header);
	}

	@Given("^under it we will have two link button \"([^\"]*)\" that when clicked will have \"([^\"]*)\" header$")
	public void under_it_we_will_have_two_link_button_that_when_clicked_will_have_header(String arg1, String arg2) throws Throwable {
	    FundingExpressObjectPage FEpage= new FundingExpressObjectPage();
		List<WebElement> links= homePage.relatedSection.findElements(By.tagName("a"));
		WebElement link= links.get(0);
	    Assert.assertEquals(2, links.size());
	    Assert.assertEquals(arg1, link.getText());
	    link.click();
	    Assert.assertEquals(arg2, FEpage.header.getText());
	}

	@Given("^\"([^\"]*)\" that when clicked \"([^\"]*)\" and this text next to it \"([^\"]*)\"$")
	public void that_when_clicked_and_this_text_next_to_it(String arg1, String arg2, String arg3) throws Throwable {
		LoanDeliveryObjectPage loanPage= new LoanDeliveryObjectPage();
	    List<WebElement> links= homePage.relatedSection.findElements(By.tagName("a"));
	    WebElement link= links.get(1);
	    Assert.assertEquals(arg1, link.getText());
	    link.click();
	    List<WebElement> headers= loanPage.header.findElements(By.tagName("h1"));
	    List<WebElement> texts= loanPage.header.findElements(By.tagName("span"));
	    String header= headers.get(0).getText();
	    String text= texts.get(0).getText();
	    Assert.assertEquals(arg2, header);
	    if(!arg3.equals(text)){
	    	System.out.println("Text: "+arg3+" didn't match");
	    }else{
	    	System.out.println("Text match");
	    }
	}
}
