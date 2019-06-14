package com.pol.bss.pol_bss_automationtest.frontend.stepdefinitions;

import static java.util.Arrays.stream;

import com.pol.bss.pol_bss_automationtest.frontend.steps.*;

import cucumber.api.java.es.Dado;
import net.thucydides.core.annotations.Steps;

public class CommonStepDefinitions {

    @Steps
    CommonSteps commonSteps;

    @Dado("^Me logueo exitosamente en Edmodo$")
    public void meLogueoCorrectamente() {
        commonSteps.meLogueoCorrectamente();
    }

}