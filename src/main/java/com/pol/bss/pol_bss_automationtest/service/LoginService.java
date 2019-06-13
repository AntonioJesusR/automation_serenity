package com.pol.bss.pol_bss_automationtest.service;

import static utils.EnvironmentBuilder.*;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class LoginService extends BaseService {

    //(EL VOID LO SUSTITUIMOS POR RESPONSE)
    public static void login(String username, String passhashed) {
       // return request(BSS_AUTHENTICATION_ENDPOINT + LOGIN, HttpMethod.POST, SerenityRest.given());
    }

    public static void loginBearer(String base) {

        //return request(BH_BEARER_TOKEN_ENDPOINT,
          //      HttpMethod.POST,
            //    SerenityRest.given().header("Authorization", base));

    }


}