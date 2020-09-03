package PageComponents;

import Pages.BasePage;
import Utils.DriverManager;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Header {
    WebDriver driver;
    @FindBy(css = ".lightbox")
    private WebElement changeRegionalSettingsButton;

    @FindBy(css = ".language")
    private WebElement selectedLanguage;

    @FindBy(css = ".image .title")
    private WebElement shoppingCartTitle;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public RegionalSettings getRegionalSettings() {
        changeRegionalSettingsButton.click();
        return new RegionalSettings(driver);
    }

}
