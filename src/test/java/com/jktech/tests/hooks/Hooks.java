package com.jktech.tests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Failure Info", "Test failed at step: " + scenario.getName());
        }
    }
}