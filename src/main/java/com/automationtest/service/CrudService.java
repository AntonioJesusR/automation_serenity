package com.automationtest.service;

import com.automationtest.SessionVariables;
import com.automationtest.service.dto.ClienteDto;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.core.Serenity.setSessionVariable;

public class CrudService extends BaseService {

    public static Response crear() {
        ClienteDto cliente1 = new ClienteDto("Antoñito","Rangel","RangelA@gmail.com",777878734,"Dolor de Tripa","",true,"01667658V","2019-06-14");
        setSessionVariable(SessionVariables.DNI).to(cliente1.getDni());
        return request("http://localhost:8080/api/clientes/create",
              HttpMethod.POST, SerenityRest.given().body(cliente1));

    }

    public static Response borrar(String id) {
        Long ids = Long.parseLong(id);
        return request("http://localhost:8080/api/clientes/delete/"+ids,
                HttpMethod.DELETE, SerenityRest.given());

    }
}
