package br.daniela.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Login.feature",
		glue = "br.daniela.cucumber.steps",
		plugin = "pretty",
		dryRun = false,
		tags = "@Login",
		strict = false
			
		)

public class Runner {

	
	
}
