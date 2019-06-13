package com.pol.bss.pol_bss_automationtest.backend.steps;

import com.pol.bss.pol_bss_automationtest.SessionVariables;
import com.pol.bss.pol_bss_automationtest.service.LoginService;
import com.pol.bss.pol_bss_automationtest.util.UserCredentials;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.sql.Connection;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class CommonSteps {


    Connection connection;

    @Step
    public void loginSystem() {
        UserCredentials user = sessionVariableCalled(USER_CREDENTIALS);
        //Response res = LoginService.login(user.getUsername(), user.getPassHashed());
        //int response = res.getStatusCode();


        //setSessionVariable(VERIFY).to(response);
    }

    @Step
    public void verificationResponse(String state) {
        int res = Integer.parseInt(sessionVariableCalled(VERIFY).toString());
        if (state.trim().equalsIgnoreCase("successfully")) {
            assertEquals(200, res);
        } else {

            assertTrue(res != 200);
        }
    }

    @Step
    public void loginOk() {
        Response response = sessionVariableCalled(RESPONSE_LOGIN);

        assertEquals(200, response.getStatusCode());
        setSessionVariable(STATUS_CODE).to(response.getStatusCode());
    }


    @Step
    public void bearerToken(Response res) {
        String ar = res.getHeaders().getValue("Authorization");
        setSessionVariable(BEARER_TOKEN).to(ar);
    }

    @Step
    public void check_empty(Response res, String empty) {
        Object[] casted = res.as(Object[].class);
        assertTrue(empty.equalsIgnoreCase("empty") ? casted.length == 0 : casted.length > 0);
    }

    @Step
    public void codingError() {
        Response response = sessionVariableCalled(WRONG_RESPONSE);
        assertEquals(500, response.statusCode());
    }

    @Step
    public void check_emp(String empty) {
        Response res = sessionVariableCalled(QUERY_RESULT);
        this.check_empty(res, empty);
    }

}
