package StepDefs;

import Pages.HomePage;
import enums.EssentialElementLocalisations;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LocalisationStepDefs extends BaseStepDefs {

    @When("I change the {string} to {string}")
    public void iChangeTheTo(String setting, String language) {
        homePage = new HomePage(driver).getHeader()
                .getRegionalSettings()
                .selectRegionalSettings(setting, language, driver)
                .saveSettings();

    }

    @Then("essential web elements appear in {string}")
    public void essentialWebElementsAppearIn(String language) {
        Assert.assertEquals(EssentialElementLocalisations.getElementsLocalisation(language), homePage.getEssentialElementsTextAsList());
    }


}
