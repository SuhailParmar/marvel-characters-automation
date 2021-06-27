package com.yapily.automation.steps;

import io.cucumber.java.en.Given;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    @Given("I am an unauthenticated user")
    public void iAmAnUnauthenticatedUser() {
        // There is currently no authentication so no logic is required
    }
}