package com.pol.bss.pol_bss_automationtest.frontend.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static utils.EnvironmentBuilder.*;
import com.pol.bss.pol_bss_automationtest.engine.UiSteps;
import com.pol.bss.pol_bss_automationtest.util.SeleniumWait;
import com.pol.bss.pol_bss_automationtest.utils.Page;

import java.util.List;

import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonSteps extends UiSteps {

    @Steps
    private MeLogueoStep melogueo;

    public void meLogueoCorrectamente(){
        melogueo.navegoAEdmodo();
        melogueo.introducirCredenciales();
        melogueo.funcionDeLogin();
    }
}