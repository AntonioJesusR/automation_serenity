package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.thucydides.core.annotations.Steps;


public class CommonStepDefinitions {


    @Steps
    public CommonSteps common;


    @Given("^I log into the system-back with a valid OTP$")
    public void loginDefault() {
        common.loginSystem();

    }


    @Then("^I should be logged successfully$")
    public void logok() {
        common.loginOk();

    }

    @Given("^I have a login token$")
    public void token() {
        Response response = sessionVariableCalled(RESPONSE_LOGIN);
        common.bearerToken(response);
    }

    @Then("I get an error")
    public void errorcode() {
        common.codingError();
    }

    @And("^the hashed password is (.+)$")
    public void enter_password(String password) {
        setSessionVariable(POL_BACK_HASHED_PASSWORD).to(password);
    }

    @Then("^the result should be of (.+) content$")
    public void result_not_empty1(String isEmpty) {
        common.check_emp(isEmpty);

    }

    @Then("^the result should be (.+)$")
    public void result_not_emtpy(String empty) {
        common.check_emp(empty);

    }

    @Given("^I have selected a branch with code (\\d+)$")
    public void giveBranch(Integer branch) {
        setSessionVariable(BRANCH_FAD_CODE).to(branch);
    }

    // BACKGROUND FOR VOL VAL COMPARISON


    @Given("^I have selected the pillar (.+) with subpillar (.+)$")
    public void select_pillar_and_subpillar(String pillar, String subpillar) {
        setSessionVariable(PILLAR).to(pillar);
        setSessionVariable(SUB_PILLAR).to(subpillar);
    }

    @Given("^I have a query limit set to (\\d+)$")
    public void limitQuery(Integer limit) {

        setSessionVariable(LIMIT).to(limit);
    }

    @Then("^The request must be (.+)$")
    public void verificationResp(String state) {
        common.verificationResponse(state);
    }

    @And("^I choose a date range from (.+) to (.+)$")

    public void dateRangeByUser(String dateFrom, String dateTo) {
        LocalDateTime dateTime;
        String datesTo = dateTo;
        String datesFrom = dateFrom;

        if (dateTo.trim().equalsIgnoreCase("today")) {

            dateTime = LocalDateTime.now();
            datesTo = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        }
        if (dateFrom.trim().equalsIgnoreCase("today")) {

            dateTime = LocalDateTime.now();
            datesFrom = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        }
        if (dateFrom.trim().equalsIgnoreCase("yesterday")) {

            dateTime = LocalDateTime.now().minusDays(1);
            datesFrom = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        }
        if (dateTo.trim().equalsIgnoreCase("yesterday")) {

            dateTime = LocalDateTime.now().minusDays(1);
            datesTo = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        }
        if (dateTo.trim().equalsIgnoreCase("weekly")) {

            dateTime = LocalDateTime.now().minusDays(6);
            datesTo = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        }
        if (dateFrom.trim().equalsIgnoreCase("weekly")) {

            dateTime = LocalDateTime.now().minusDays(6);
            datesFrom = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        setSessionVariable(TRADING_DATE_TO).to(datesTo);
        setSessionVariable(TRADING_DATE_FROM).to(datesFrom);
    }
}

