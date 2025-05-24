package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		glue = {"stepdefinitions","AppHooks"},
//		tags = "@company",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //extent reporter adapter
				"timeline:test-output-thread/",          //file with thread count
				"rerun:target/failedScenarios.txt",		//file with failed scenario
				"junit:target/cucumber-reports/Cucumber.xml"
		}
		)

public class MyTestRunner {
	
	
}
