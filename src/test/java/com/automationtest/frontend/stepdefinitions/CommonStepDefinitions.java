package com.automationtest.frontend.stepdefinitions;


import com.automationtest.frontend.steps.CommonSteps;

import cucumber.api.java.es.Dado;
import net.thucydides.core.annotations.Steps;

public class CommonStepDefinitions {

    @Steps CommonSteps commonSteps;

    @Dado("^Me logueo exitosamente en Edmodo$")
    public void meLogueoCorrectamente() {
        commonSteps.meLogueoCorrectamente();
    }

}