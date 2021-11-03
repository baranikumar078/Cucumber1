package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",glue="org.stepdefinition",dryRun=false,snippets=SnippetType.CAMELCASE)
public class TestRunnerClass {

	//BDD is a way for software teams to work that closes the gap between business people and technical people by:
}
