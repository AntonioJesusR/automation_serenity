package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import com.pol.bss.pol_bss_automationtest.backend.steps.LogoutSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class LogoutStepDefinition {

    @Steps
    CommonSteps common;

    @Steps
    LogoutSteps logout;


    @Then("^I should be logged out$")
    public void logoutok() {
        logout.logoutOk();
    }


}
