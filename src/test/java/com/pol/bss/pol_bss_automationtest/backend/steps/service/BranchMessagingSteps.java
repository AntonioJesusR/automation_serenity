package com.pol.bss.pol_bss_automationtest.backend.steps.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import com.pol.bss.pol_bss_automationtest.service.dto.MessageDto;
import com.pol.bss.pol_bss_automationtest.service.dto.MessageSummaryDto;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.ENDPOINT_RESPONSE;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

//import com.pol.bh.branchmessaging.dto.MessageSummaryDto;


public class BranchMessagingSteps {
    @Steps
    CommonSteps common;

    @Step
    public void checkMessages() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        List<MessageSummaryDto> messageSummaryDto = new ArrayList<>();
        boolean a = false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            messageSummaryDto = mapper.readValue(response.getBody().asString(),
                    new TypeReference<List<MessageSummaryDto>>() {
                    });
            a = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        softAssertions.assertThat(a).isEqualTo(true);
        softAssertions.assertAll();
    }

    @Step
    public void checkMessage() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        MessageDto messageSummaryDto = new MessageDto();
        boolean a = false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            messageSummaryDto = mapper.readValue(response.getBody().asString(),
                    new TypeReference<MessageDto>() {
                    });
            a = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        softAssertions.assertThat(a).isEqualTo(true);
        softAssertions.assertAll();
    }


    @Step
    public void checkUnreadMessagesNumber() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertThat(Integer.valueOf(response.getBody().asString())).isEqualTo(false);
        softAssertions.assertAll();

    }


    @Step
    public void checkGetMessageByIdPoid() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        ObjectMapper mapper = new ObjectMapper();
        MessageDto messageSummaryDto = new MessageDto();
        boolean a = false;
        try {
            messageSummaryDto = mapper.readValue(response.getBody().asString(),
                    new TypeReference<MessageDto>() {
                    });
            a = true;
        } catch (IOException e) {

            e.printStackTrace();
        }
        softAssertions.assertThat(a).isEqualTo(true);
        softAssertions.assertAll();

    }


    @Step
    public void checkSendMessage() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(true);
        softAssertions.assertAll();
    }

    @Step
    public void checkMessageRead() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertThat(response.getBody().as(Boolean.class).equals(true) || response.getBody().as(Boolean.class).equals(false)).isEqualTo(true);
        softAssertions.assertAll();


    }


    @Step
    public void checkAcknowledgeMessage() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertThat(response.getBody().as(Boolean.class).equals(true) || response.getBody().as(Boolean.class).equals(false)).isEqualTo(true);
        softAssertions.assertAll();
    }

}


