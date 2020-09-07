package StepDefs;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class FooterStepDefs extends BaseStepDefs {
    @Given("I am on home page")
    public void iAmOnHomePage() {
        homePage = new HomePage(driver)
                .openPage();
    }

    @When("I click on the links in the footer area")
    public void iClickOnTheLinksInTheFooterArea() {

    }

    @Then("corresponding pages open")
    public void correspondingPagesOpen() {
        SoftAssertions softAssertions = new SoftAssertions();

        homePage.getFooterLinksTextAndPageTitlesTheyOpen().forEach((key, value) -> softAssertions.assertThat(value)
                .as("Page title is '" + value
                        + "' But link text that launched this page is: '" + key
                        + "'\n")
                .isEqualTo(key));
    }
}
