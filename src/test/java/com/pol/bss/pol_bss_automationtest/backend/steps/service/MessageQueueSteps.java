package com.pol.bss.pol_bss_automationtest.backend.steps.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import com.pol.bss.pol_bss_automationtest.service.MessageQueueService;
import com.pol.bss.pol_bss_automationtest.service.dto.MessageQueueDTO;
import com.pol.bss.pol_bss_automationtest.util.UserCredentials;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.ENDPOINT_RESPONSE;
import static com.pol.bss.pol_bss_automationtest.SessionVariables.USER_CREDENTIALS;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

public class MessageQueueSteps {
    @Steps
    CommonSteps common;

    @Step
    public void checkNotifications() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertAll();
    }
    
    @Step
    public void checkNotify() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertAll();





    }
}
