package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pol.bss.pol_bss_automationtest.service.dto.MessageSummaryDto;
//import com.pol.bh.branchmessaging.dto.MessageSummaryDto;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.RESPONSE_SENT_MESSAGES;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class SentMessagesStepsDefinition {

    @Then("^I check messages information is not empty$")
    public void checkMessagesInfo() {
        Response messagesResponse = sessionVariableCalled(RESPONSE_SENT_MESSAGES);
        ObjectMapper objectMapper = new ObjectMapper();
        List<MessageSummaryDto> list = new ArrayList<>();
        try {
            list = objectMapper.readValue(messagesResponse.getBody().asString(),
                    new TypeReference<List<MessageSummaryDto>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MessageSummaryDto message : list) {
            if (message.getAuthor() == null) {
                break;
            }
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(message.getPriority().toString().isEmpty()).isEqualTo(false);
            softAssertions.assertThat(message.getSubject().isEmpty()).isEqualTo(false);
            softAssertions.assertThat(message.getDateSent()!=null).isEqualTo(true);
            softAssertions.assertThat(message.getAuthor().isEmpty()).isEqualTo(false);
            softAssertions.assertAll();

        }

    }

}
