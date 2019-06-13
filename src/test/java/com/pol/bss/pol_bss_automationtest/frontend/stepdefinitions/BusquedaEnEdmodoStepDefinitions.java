package com.pol.bss.pol_bss_automationtest.frontend.stepdefinitions;

import com.pol.bss.pol_bss_automationtest.frontend.steps.BusquedaEnEdmodoSteps;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.core.Serenity.setSessionVariable;

public class BusquedaEnEdmodoStepDefinitions {

    @Steps
    BusquedaEnEdmodoSteps busquedaEdmodo;

    @Cuando("^Introduzco (.+) en el buscador$")
    public void introduzcoBusquedaEnElBuscador(String busqueda) {
    setSessionVariable("BUSQUEDA").to(busqueda);
    busquedaEdmodo.busqueda();
    }

    @Entonces("^Compruebo las diferentes pestañas y sus resutados$")
    public void comprueboLasOpciones() {
        busquedaEdmodo.navegacionDeTabs();
    }


}
