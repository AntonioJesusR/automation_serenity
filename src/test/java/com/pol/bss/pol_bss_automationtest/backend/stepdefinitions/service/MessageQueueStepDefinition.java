package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions.service;

import com.pol.bss.pol_bss_automationtest.backend.steps.service.MessageQueueSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class MessageQueueStepDefinition {
    @Steps
    MessageQueueSteps messageQueueSteps;

    @Then("^I check message notification$")
    public void checkNotifications() {
        messageQueueSteps.checkNotifications();
    }

    @Then("^I check notify$")
    public void checkNotify() {
        messageQueueSteps.checkNotify();
    }
}
