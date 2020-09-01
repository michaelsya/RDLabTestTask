package StepDefs;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.DriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BaseStepDefs {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage;
    HomePage homePage;
    SoftAssertions softly = new SoftAssertions();

    public void softlyAssertAll() {
        softly.assertAll();
    }


}
