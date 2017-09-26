@Fanniemae_Test
Feature: Fanniemae Test 


Background: 
	Given on fanniemae webpage 

@smoke
@Fanniemae_Test1 
Scenario: Features test 
	And you verify the title to be "Pricing & Execution - Whole Loan (PE - Whole Loan)" 
	Then then the logo with the link "http://www.fanniemae.com/portal/index.html" should be displayed 
	And search box should have "Search forms, documents, site content, etc..." displayed 
	And search for something unrelated to mortage example "playstation" 
	Then you should get No page found containing "playstation" or "did not match any documents" 
	And search for something related example "house" 
	Then a table on the mid left with "Refine Search" text should be displayed and another showing "All Results" and the number of results and total number 

@regression
@Fanniemae_Test2 
Scenario: Verifications 
	And the search icon button is displayed 
	And the login button is displayed 
	And Single-Family drop down list with Mutilfamily text is displayed 
	And by clicking on the Single-Family link, the title should be "Fannie Mae Single-Family Business Homepage" 
	And these tabs should be present next to it 
		|Originating & Underwriting|
		|Pricing & Execution|
		|Delivering|
		|Servicing|
		|Training|
		|Technology Solutions|
	And by clicking on the Mutilfamily Mutilfamily link, the title should be "Fannie Mae Multifamily Business Homepage" 
	And these tabs should be present 
		|Origination & Underwriting|
		|Pricing & Execution|
		|Delivery|
		|Servicing|
		|Asset Management|
		|Learning Center|
		|MBS|
		|About Us|
		
@Fanniemae_Test3 
Scenario: Verify1 
	And a image with "PE - Whole Loan" text 
	And next to it this paragrahaph "Pricing & Execution - Whole Loan® (PE - Whole Loan) application, our industry-leading whole loan committing platform, provides ease of use, flexibility, and certainty for sellers. Take advantage of an enhanced committing and pipeline management experience." 
	And a tab Launch App that will take us to a link to login "https://sso.fanniemae.com/fmWebApp/fmlogin.jsp" 

@Fanniemae_Test4 
Scenario: Verify2 
	And under Launch App button we should have a Manage My account tab with three main rows 
		|Reset My Password|
		|Users: Update Password/Profile|
		|Admins: Manage Applications/Users|
	And we should have a button that when we click should give us a drop down list with text "If account is locked or deactivated, or you forgot your user ID, contact your Technology Manager administrator." 
	And another tab with "See Availability" text and a sentence "Technology Application Availability" 
	And when clicking it it should take us to this page "https://www.fanniemae.com/singlefamily/technology-availability" 
	And Under this page we should have the same logo as the main page 
	And we will have "Technology Application Availability" and this statement next to it "See a list of technology hours of availability and outages for your Fannie Mae application(s)." 
	And on the left side we should have "User Help" 
	And on the left side we will have a tab that says "Hours of Availability and Outages by Application*" 

@smoke
@Fanniemae_Test5 
Scenario: Verify3 
	And we have another tab that says "Bookmarking Help" and under it a link text that says "Bookmarking Best Practices" 
	And another tab that says "Related Applications" 
	And under it we will have two link button "Funding Express" that when clicked will have "Funding Express" header 
	And "Loan Delivery" that when clicked "Loan Delivery" and this text next to it "Loan Delivery is a Web-based application through which lenders submit loans to Fannie Mae for Whole loan sale and MBS Pools. The updated Loan Delivery application is equipped with more intuitive navigation, streamlined editing and reporting, expanded data delivery options, and much more.Loan Delivery is a Web-based application through which lenders submit loans to Fannie Mae for Whole loan sale and MBS Pools. The updated Loan Delivery application is equipped with more intuitive navigation, streamlined editing and reporting, expanded data delivery options, and much more."