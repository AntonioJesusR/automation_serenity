package com.automationtest;

import com.automationtest.engine.ExtendedCucumberRunner;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(plugin = {"pretty"},
        glue = {
                "com.pol.bss.automationtest"},
        features = "src/test/resources/features"
)

public class CucumberTestSuite {

}

