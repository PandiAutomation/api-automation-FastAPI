package com.jktech.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.jktech.tests.stepdefinitions", "com.jktech.tests.hooks"},
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    tags = "@Execute"   
)
public class TestRunner extends AbstractTestNGCucumberTests {
}