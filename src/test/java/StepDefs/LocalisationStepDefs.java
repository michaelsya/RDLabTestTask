package StepDefs;

import enums.EssentialElementLocalisations;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocalisationStepDefs extends BaseStepDefs {

    @When("I change the {string} to {string}")
    public void iChangeTheTo(String setting, String language) {
        homePage.getHeader()
                .getRegionalSettings()
                .selectRegionalSettings(setting, language, driver);

    }

    @Then("essential web elements appear in {string}")
    public void essentialWebElementsAppearIn(String language) {
        softly.assertThat(homePage.getEssentialElementsTextAsList())
                .isEqualTo(EssentialElementLocalisations.getElementsLocalisation(language));
    }


}
