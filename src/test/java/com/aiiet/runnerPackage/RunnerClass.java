package com.aiiet.runnerPackage;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\PC1\\eclipse-workspace\\cheapair\\src\\test\\resources\\features",
				
				glue="com.aiiet.stepdefinition",	
				plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"html:reports/reports.html"},monochrome=true)
public class RunnerClass {
	
}


