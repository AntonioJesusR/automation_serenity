package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions.service;

import com.pol.bss.pol_bss_automationtest.backend.steps.service.AuthSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AuthStepDefinition {
    @Steps
    AuthSteps authSteps;



    @Then("^Response with user logout$")
    public void user_logging_out_from_system() {
        authSteps.userWillBeLogout();
    }

       @Then("^Check I have the OTP status$")
    public void otp_status() {
        authSteps.OTPStatus();
    }


    @Then("^User successfully login with a new temporary password$")
    public void success_login_with_temporary_password() {
        authSteps.SuccessLoginTempPass();
    }

    @Then("^This endpoint will unset the OTP flag$")
    public void endpoint_set_Otp_Flag() {
        authSteps.unsetOTPFlag();
    }


    @Then("^Checks if users can Login or not$")
    public void flag_is_setting() {
        authSteps.checkFlagMaintenance();
    }


    @Then("^Check changes the maintenance flag with the value.$")
    public void checkChangedMaintenanceFlag() {
        authSteps.checkFlagMaintenance();
    }


     @Then("^Checks the maintenance flag ON$")
    public void users_redirect_to_maintenance() {
        authSteps.checkFlagMaintenanceOn();
    }

      @Then("^All users or individual users will be logout$")
    public void all_users_will_be_logout() {
        authSteps.AllUsersWillBeLogout();
    }

   @Then("^Allow the users to log in$")
    public void allow_users_to_log_in() {
        authSteps.allowUserLogin();
    }

   @And("^Additionally, system state is set to 'System configuration changed'$")
    public void additionally_system_set_configuration_changed() {
        authSteps.SetConfigurationChanged();
    }

    @Then("^Visibility config logout set$")
    public void visibility_config_logout_set() {
        authSteps.Visibility();
    }

   @Then("^User is able to login$")
    public void user_has_successfully_logged() {
        authSteps.CheckSuccessLogin();
    }

    @Then("^return the public key$")
    public void getPublicKey() {
        authSteps.checkGetPublicKey();
    }

    @And("^user logged request this api pdf$")
    public void requestSwaggerAPI() {
        authSteps.requestSwaggerApi();
    }

    @Then("^Activity threshold successfully updated$")
    public void successfullyUpdated() {
        authSteps.successfullyUpdated();
    }

}
