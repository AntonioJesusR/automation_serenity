package com.pol.bss.pol_bss_automationtest.backend.steps;

import static net.serenitybdd.core.Serenity.setSessionVariable;

import com.pol.bss.pol_bss_automationtest.SessionVariables;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {
    @Steps
    CommonSteps common;

    @Step
    public void getBranches(String userName) {


        //Response res = AuthService.branchByUser(userName);
        //setSessionVariable(SessionVariables.QUERY_RESULT).to(res);
        // el query response me esta devolviendo la respuesta del query

    }
}
