package com.Testing.stepsDef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\vinay\\OneDrive\\Desktop\\notes\\my-repo\\mercurynewtours-test-framework\\src\\test\\resources\\endToEnd.feature",format = {"pretty", "html:target/cucumber.html"}
)
public class RunnerClass extends Hooks{

}
