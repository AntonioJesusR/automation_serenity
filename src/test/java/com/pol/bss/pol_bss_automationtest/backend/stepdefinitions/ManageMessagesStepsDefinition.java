package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import com.pol.bss.pol_bss_automationtest.backend.steps.PostgreSQLStep;
import com.pol.bss.pol_bss_automationtest.service.dto.MessageSummaryDto;
import com.pol.bss.pol_bss_automationtest.util.UserCredentials;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import utils.EnvironmentBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.pol.bss.pol_bss_automationtest.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;


public class ManageMessagesStepsDefinition {



    @Steps
    PostgreSQLStep postgreSQLStep;

    @Steps
    CommonSteps common;




    @Then("^I get last message ID")
    public void getMessagesByPriority() throws SQLException {

        postgreSQLStep.getIDLastMessageDB();
    }

    @And("^I connect to the DataBase$")
    public void getBranchesImanage() throws SQLException {
        UserCredentials u = new UserCredentials();
        postgreSQLStep.getBranchesInfoByUser(u.getUsername());

    }


    }