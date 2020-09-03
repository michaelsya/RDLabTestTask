package PageComponents;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class Header {
    @FindBy(css = ".lightbox")
    private WebElement changeRegionalSettingsButton;

    @FindBy(css = ".language")
    private WebElement selectedLanguage;

    @FindBy(css = ".image .title")
    private WebElement shoppingCartTitle;

    public RegionalSettings getRegionalSettings() {
        changeRegionalSettingsButton.click();
        return new RegionalSettings();
    }

}
