package com.pol.bss.pol_bss_automationtest.backend.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.pol.bss.pol_bss_automationtest.DniUsed;

import com.pol.bss.pol_bss_automationtest.service.CrudService;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

public class CrudFeatureSteps {
   private CrudService service;
    private Connection connection;

    @Step
    public void introducirCliente(){
        Response res = CrudService.crear();
        int status_code = res.getStatusCode();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        HashMap<String,Object> user = new HashMap<>();
        try {
            user = mapper.readValue(res.getBody().asString(), new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        String id = user.get("id").toString();
        DniUsed.setDniUsed(id);
        setSessionVariable(STATUS_CODE).to(status_code);
    }

    @Step
    public void comprobacionDeOk(){
        String verify = sessionVariableCalled(STATUS_CODE).toString();
        int status = Integer.parseInt(verify);
        Assert.assertTrue(status<300);

    }


    @Step
    public void borrado(){
        String id = DniUsed.getDniUsed();
        Response res = CrudService.borrar(id);
        int status_code = res.getStatusCode();
        setSessionVariable(STATUS_CODE).to(status_code);
    }

}
