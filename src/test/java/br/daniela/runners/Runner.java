package br.daniela.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty"},
		features = "src/test/resources/features/EscolherProdutos.feature",
		glue = { "br/daniela/cucumber/steps" },
		tags = "@Login",
		dryRun = false,
		strict = false
		)

public class Runner {}
