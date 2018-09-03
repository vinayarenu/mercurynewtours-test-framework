package com.Testing.stepsDef;

import com.Testing.helpers.BasePage;
import com.Testing.pageObjects.*;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class Steps {
    RegistrationPage registrationPage = new RegistrationPage();


    @Before
    public void homepage() {
        BasePage.driver.get("http://newtours.demoaut.com/");
    }

    @After
    public void screenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            //take screenshot and store as a file format
            File screenshotFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);

            //now copy the screenshot to desired location using copyFile()
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Prashanth Reddy\\Desktop\\javaprojects\\MyNewtoursProject\\src\\test\\java\\com\\Testing\\screenshot.png"));
            BasePage.driver.quit();
        }
    }


    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        String actual = registrationPage.isOnHomePage();
        assertThat(actual, endsWith(".com/"));
    }

    @When("^selects Register$")
    public void selects_Register() {
        registrationPage.register();

    }

    @When("^enters all the required registration information$")
    public void enters_all_the_required_registration_information() {

        registrationPage.fillForm();
    }

    @When("^selects submit$")
    public void selects_submit() {
        registrationPage.submitBtn();
    }

    @Then("^user should successfully register$")
    public void user_should_successfully_register() {
        String actual = registrationPage.userSuccessfullyRegister();
        assertThat(actual, endsWith("success.php"));
    }



}
