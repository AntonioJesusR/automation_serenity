package com.pol.bss.pol_bss_automationtest;

import com.pol.bss.pol_bss_automationtest.engine.ExtendedCucumberRunner;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(plugin = {"pretty"},
        glue = {
                "com.pol.bss.pol_bss_automationtest"},
        features = "src/test/resources/features"
)

public class CucumberTestSuite {

}

