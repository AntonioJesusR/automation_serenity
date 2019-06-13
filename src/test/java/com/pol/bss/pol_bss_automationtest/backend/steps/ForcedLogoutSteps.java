package com.pol.bss.pol_bss_automationtest.backend.steps;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.junit.Assert.assertEquals;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class ForcedLogoutSteps {


    @Steps
    CommonSteps commonSteps;

    @Step
    public void wait_Maintenance() throws InterruptedException {
        Thread.sleep(20000);
    }


    @Step
    public void logoutAllOk() {
        Response response = sessionVariableCalled(VERIFY);
        assertEquals(200, response.statusCode());

    }


}
