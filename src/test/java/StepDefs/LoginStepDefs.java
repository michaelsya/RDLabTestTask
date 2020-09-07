package StepDefs;


import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class LoginStepDefs extends BaseStepDefs {

    @Given("I am on a login page")
    public void iAmOnALoginPage() {
        loginPage = new LoginPage(driver)
                .openPage();
    }

    @When("I enter {string} in the email address field")
    public void iEnterInTheEmailAddressField(String email) {
        loginPage.enterEmailAsLogin(email);

    }

    @Then("I see an error message that says {string}")
    public void iSeeAnErrorMessageThatSays(String expectedErrorMessage) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(loginPage.getLoginErrorText()).contains(expectedErrorMessage);
        softly.assertAll();
    }

    @When("I enter {string} in the password field  and try to login")
    public void iEnterInThePasswordFieldAndTryToLogin(String password) {
        loginPage.enterPassword(password)
                .attemptLogin();
    }

    @Then("I get {string} notification")
    public void iGetNotification(String expectedNotificationText) {
        assertThat(loginPage.getSuccessNotificationText(), containsString(expectedNotificationText));
    }


}
