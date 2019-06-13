package com.pol.bss.pol_bss_automationtest.backend.steps.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import com.pol.bss.pol_bss_automationtest.service.dto.LoginResponseDto;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.ENDPOINT_RESPONSE;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class AuthSteps {
    @Steps
    CommonSteps common;


    @Step
    public void userWillBeLogout() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);

        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(true);
        softAssertions.assertAll();

    }



    @Step
    public void OTPStatus() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);

        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertAll();

    }

    @Step
    public void SuccessLoginTempPass() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().as(Boolean.class)).isEqualTo(true);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(false);
        softAssertions.assertAll();
    }



    @Step
    public void unsetOTPFlag() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().as(Boolean.class)).isEqualTo(true);
        softAssertions.assertAll();
    }


    @Step
    public void checkFlagMaintenance() {

        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);

        softAssertions.assertThat(response.getBody().as(Boolean.class).getClass().equals(Boolean.class)).isEqualTo(true);
        softAssertions.assertAll();
    }

    @Step
    public void checkFlagMaintenanceOn() {

        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);

        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(true);
        softAssertions.assertAll();
    }




    @Step
    public void AllUsersWillBeLogout() {

        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        assert (response.getStatusCode() == 200);

    }


    @Step
    public void allowUserLogin() {

        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);

        softAssertions.assertThat(response.getBody().as(Boolean.class).getClass().equals(Boolean.class)).isEqualTo(true);
        softAssertions.assertAll();

    }

    @Step
    public void SetConfigurationChanged() {
    }

    @Step
    public void Visibility() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(true);
        softAssertions.assertAll();
    }


    @Step
    public void CheckSuccessLogin() {

        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        Boolean a = false;
        ObjectMapper mapper = new ObjectMapper();
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        try {
            loginResponseDto = mapper.readValue(response.getBody().asString(),
                    new TypeReference<LoginResponseDto>() {
                    });
            a = true;
        } catch (IOException e) {

            e.printStackTrace();
        }
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode() == 200).isEqualTo(true);
        softAssertions.assertThat(a).isEqualTo(true);
        softAssertions.assertThat(loginResponseDto.toString().isEmpty()).isEqualTo(false);
        softAssertions.assertAll();
    }

    @Step
    public void checkGetPublicKey() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode() == 200).isEqualTo(true);
        softAssertions.assertThat(response.getBody().toString().isEmpty()).isEqualTo(false);
        softAssertions.assertThat(response.getBody().toString().length() == 56).isEqualTo(true);
        softAssertions.assertAll();
    }

    @Step
    public void requestSwaggerApi() {
    }

    @Step
    public void successfullyUpdated() {
        Response response = sessionVariableCalled(ENDPOINT_RESPONSE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
        softAssertions.assertThat(response.getBody().asString().isEmpty()).isEqualTo(true);
    }


}

