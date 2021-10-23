package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utility.ConfigReader;
import com.trycloud.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    @When("user enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {
        loginPage.login(username,password);
    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {
        Assert.assertEquals("Dashboard - Trycloud QA", Driver.getDriver().getTitle());
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {

    }
}
