package com.pol.bss.pol_bss_automationtest.backend.stepdefinitions;

import com.pol.bss.pol_bss_automationtest.backend.steps.CommonSteps;
import com.pol.bss.pol_bss_automationtest.backend.steps.LoginSteps;

import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {
	@Steps 
	CommonSteps common;
	
	@Steps
	LoginSteps loginsteps;

//    @Pending
//	@When("^I request my branches$")
//	public void request_branches(){
//		loginsteps.getBranches(sessionVariableCalled(POL_USERNAME).toString());
//	}
}
