package com.cucumber.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\main\\java\\com\\cucumber\\Freatures"},
		glue = {"com.cucumber.stepdefinition","com.cucumber.hooks"},
		plugin = {"pretty"},
		monochrome = true
		)
public class TestRunner {

}
