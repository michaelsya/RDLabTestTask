package StepDefs;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;
import java.util.stream.Stream;

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
        Stream<Map.Entry<String, String>> stream = homePage.getFooterLinksTextAndPageTitlesTheyOpen().entrySet().stream();
        stream.forEach(stringStringEntry -> {
            //values represent the actual page titles and keys represent link texts (which should be expected results)
            softly.assertThat(stringStringEntry.getValue()).as("Page title is '" + stringStringEntry.getValue()
                    + "' But link text that launched this page is: '" + stringStringEntry.getKey()
                    + "'\n").isEqualTo(stringStringEntry.getKey());
        });
        softlyAssertAll();
    }
}
