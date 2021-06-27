package com.yapily.automation.steps;

import io.cucumber.java.Before;
import net.serenitybdd.rest.SerenityRest;

public class Hooks {
    @Before
    public void log() {
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}