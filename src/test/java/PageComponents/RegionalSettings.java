package PageComponents;

import Pages.HomePage;
import Utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utils.WebElementUtils.selectButtonInDropdown;

public class RegionalSettings {
    @FindBy(xpath = "//select[@name='language_code']")
    private WebElement selectLanguage;

    @FindBy(xpath = "//select[@name='currency_code']")
    private WebElement selectCurrency;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement selectChanges;

    public HomePage saveSettings() {
        selectChanges.click();
        //refactor
        return new HomePage(DriverManager.getDriver());
    }

    public RegionalSettings selectRegionalSettings(String dropdownName, String selectButtonName, WebDriver driver) {
        selectButtonInDropdown(driver.findElement(By.xpath("//select[@name='" + dropdownName.toLowerCase()
                + "_code']")), selectButtonName);
        return this;
    }
}
