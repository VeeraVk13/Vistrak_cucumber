package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "classpath:Features", 
		glue = "com.stepDefination", 
		dryRun = false,
		monochrome = true, 
		plugin = {	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:Reports/cucumber-reports/report.html",
				"rerun:failed_Scenarios/failed_scenarios.txt"}
				
)

public class TestRunner {

}
