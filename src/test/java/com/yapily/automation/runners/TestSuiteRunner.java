package com.yapily.automation.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.yapily.automation"},
        features = {"src/test/resources/features"},
        tags = {"@context:API"},
        plugin = {"pretty","html:target/cucumber-html-report"}
)
public class TestSuiteRunner {
}