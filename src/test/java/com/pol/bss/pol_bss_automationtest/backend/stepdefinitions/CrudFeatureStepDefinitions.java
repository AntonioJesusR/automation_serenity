package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import com.pol.bss.pol_bss_automationtest.backend.steps.CrudFeatureSteps;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import java.sql.SQLException;

public class CrudFeatureStepDefinitions {

    @Steps
    private CrudFeatureSteps crud;

    @Dado("^Que lanzo la petición de agregar usuario$")
    public void peticionDeCreacion(){
        crud.introducirCliente();
    }
    @Entonces("^Compruebo que la respuesta será exitosa$")
    public void comprobacionDelPedido() {
        crud.comprobacionDeOk();
    }

    @Dado("^Que lanzo la petición de borrar usuario$")
    public void peticionDeBorrado() throws SQLException {
            crud.borrado();
    }
}
