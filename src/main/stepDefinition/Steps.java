package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Features",
//        glue={"StepDefinitions"})
public class Steps {

    @Given("^user navigates to the login page by opening Firefox$")
//Code to Open Firefox Browser and launch the login page of application to define the GIVEN step of the feature

    @When("^user enters correct username and password values$")
//take inputs for username and password fields using find element by xpath. Put the correct username and password values as inputs to define the WHEN step of the feature

    @Then(“^user gets directed to homepage$”)

//Direct to the Homepage of the application as a result of correct username and password inputs in the WHEN step. This would define the THEN step of the feature
}
