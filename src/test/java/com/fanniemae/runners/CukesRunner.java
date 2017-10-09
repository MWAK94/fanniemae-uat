package com.fanniemae.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-reports", "json:target/cucumber.json"}, 
				 features = "src/test/resources/features/", 
				 glue = "com.fanniemae.step_defs",
				 tags= "@Fanniemae_Test2",
				 dryRun = false
				 //dryRun was true
				 )
public class CukesRunner {

}
