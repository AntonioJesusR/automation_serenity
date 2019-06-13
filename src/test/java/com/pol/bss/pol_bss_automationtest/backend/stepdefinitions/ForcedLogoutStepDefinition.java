package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import com.pol.bss.pol_bss_automationtest.backend.steps.ForcedLogoutSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ForcedLogoutStepDefinition {

    @Steps
    ForcedLogoutSteps forced;

    @And("^I wait the Maintenance time$")
    public void maintenanceWait() throws InterruptedException {
        forced.wait_Maintenance();
    }

    @Then("^The revoke all users request must be successfully$")
    public void revokeAllOk() {
        forced.logoutAllOk();
    }

 }
