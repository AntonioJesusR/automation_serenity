package com.pol.bss.pol_bss_automationtest.frontend.steps;

import com.pol.bss.pol_bss_automationtest.engine.UiSteps;
import com.pol.bss.pol_bss_automationtest.frontend.pageObjects.BusquedaEnEdmodoPage;
import net.thucydides.core.annotations.Step;

public class BusquedaEnEdmodoSteps extends UiSteps {
BusquedaEnEdmodoPage page;

    @Step("Introduzco en el buscador el texto")
    public void busqueda(){
    page.buscador();
    }

    @Step("Compruebo todos los elementos que tiene la lista de pestañas y compruebo que es posible la navegación")
    public void navegacionDeTabs(){
        page.tabs();
    }

}
