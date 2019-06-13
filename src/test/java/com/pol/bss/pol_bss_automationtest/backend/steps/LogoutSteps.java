package com.pol.bss.pol_bss_automationtest.backend.steps;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.RESPONSE_LOGOUT;
import static com.pol.bss.pol_bss_automationtest.SessionVariables.STATUS_CODE;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class LogoutSteps {


    @Step
    public void logoutSystem(String bearerToken) {
        //Response res = LogoutService.deleteCredentials(bearerToken);
        //setSessionVariable(RESPONSE_LOGOUT).to(res);
    }

    @Step
    public void logoutOk() {
        Response response = sessionVariableCalled(RESPONSE_LOGOUT);
        int res = response.getStatusCode();
        assertEquals(200, res);
        setSessionVariable(STATUS_CODE).to(res);
    }


}

	
	

