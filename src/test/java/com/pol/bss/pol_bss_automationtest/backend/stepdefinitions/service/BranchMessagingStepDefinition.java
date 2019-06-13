package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions.service;

import com.pol.bss.pol_bss_automationtest.backend.steps.service.BranchMessagingSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BranchMessagingStepDefinition {

    @Steps
    BranchMessagingSteps branchMessagingSteps;



    @Then("^I check the unread messages number request$")
    public void checkUnreadMessagesNumber() {
        branchMessagingSteps.checkUnreadMessagesNumber();
    }

    @Then("^I check the send message request$")
    public void checkSendMessage() {
        branchMessagingSteps.checkSendMessage();
    }



    @Then("^I check messages$")
    public void checkMessages() {
        branchMessagingSteps.checkMessages();
    }

    @Then("^I check the message$")
    public void checkMessage() {
        branchMessagingSteps.checkMessage();
    }

    @Then("^I check the get message by ID and POID request$")
    public void checkGetMessageByIdPoid() {
        branchMessagingSteps.checkGetMessageByIdPoid();

    }

    @Then("^I check messages read$")
    public void checkMessageRead() {
        branchMessagingSteps.checkMessageRead();
    }


    @Then("^I check acknowledge message$")
    public void checkAcknowledgeMessage() {
        branchMessagingSteps.checkAcknowledgeMessage();
    }
}



