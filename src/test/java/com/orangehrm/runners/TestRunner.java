package com.orangehrm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(

        features = "src/test/resources/features/Admin.feature",
        glue = {"com.orangehrm.stepdefinitions",
                "com.orangehrm.hooks"
        },
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)


public class TestRunner  extends AbstractTestNGCucumberTests {

}

