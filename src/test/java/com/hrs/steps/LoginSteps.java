package com.hrs.steps;

import com.hrs.runners.AppTestRun;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginSteps extends AppTestRun {

    @Given("The user goes to the loginPage")
    public void theUserGoesToTheLoginPage() {
        loginPage.openLogin();
    }

    @When("The user inputs the username {string} and the password {string}")
    public void theUSerInputsTheUsernameAndThePassword(String arg0, String arg1) {
        loginPage.inputValues(arg0,arg1);
    }

    @And("The user clicks on the Submit button to login")
    public void theUserClicksOnTheSubmitButtonToLogin() {
        loginPage.submitLogin();
    }

    @Then("The Web page displays the error message {string}")
    public void theWebPageDisplaysTheErrorMessage(String arg0) {
        Assert.assertEquals(loginPage.getNotificationMessage(),arg0);
    }

    @Then("The Submit button must be disabled")
    public void theSubmitButtonMustBeDisabled() {
        Assert.assertFalse(loginPage.isSubmitEnabled());
    }

    @When("The user inputs the value {string} in the field {string}")
    public void theUserInputsTheValueInTheField(String arg0, String arg1) {
        loginPage.inputValueIn(arg0,arg1);
    }

    @Then("The Submit button must be enabled")
    public void theSubmitButtonMustBeEnabled() {
        Assert.assertTrue(loginPage.isSubmitEnabled());
    }

    @And("The user clears the field {string}")
    public void theUserClearsTheValueInTheControl(String arg0) {
        loginPage.clearTheField(arg0);
    }

    @When("The user clicks on the ForgotLink")
    public void theUserClicksOnTheForgotLink() {
        loginPage.clickOnForgotPassword();
    }

    @And("The user clicks on the Submit button to reset password")
    public void theUserClicksOnTheSubmitButtonToResetPassword() {
        loginPage.clickOnSubmitForgotPassword();
    }

    @And("The user inputs the value {string} in the username")
    public void theUserInputsTheValueInTheUsername(String arg0) {
        loginPage.inputValueInForgotForm(arg0);
    }
}