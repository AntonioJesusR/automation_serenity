package com.pol.bss.pol_bss_automationtest.frontend.stepdefinitions;

import static java.util.Arrays.stream;

import com.pol.bss.pol_bss_automationtest.frontend.steps.*;
import com.pol.bss.pol_bss_automationtest.utils.Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.stream.Collectors;

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