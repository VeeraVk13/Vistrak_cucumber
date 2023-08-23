package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "@failed_Scenarios/failed_scenarios.txt", 
		glue = "com.stepDefination", 
		dryRun = false, 
		monochrome = true
		)
public class Rerunner {

}
