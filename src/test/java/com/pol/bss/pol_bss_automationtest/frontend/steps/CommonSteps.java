package com.pol.bss.pol_bss_automationtest.frontend.steps;

import com.pol.bss.pol_bss_automationtest.engine.UiSteps;
import net.thucydides.core.annotations.Steps;

public class CommonSteps extends UiSteps {

    @Steps
    private MeLogueoStep melogueo;

    public void meLogueoCorrectamente(){
        melogueo.navegoAEdmodo();
        melogueo.introducirCredenciales();
        melogueo.funcionDeLogin();
    }
}