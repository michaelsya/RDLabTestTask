package Pages;

import PageComponents.Header;
import Utils.WebElementUtils;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    private final String HOME_URL = "http://kuopassa.net/litecart/en/";

    public List<WebElement> essentialElements;
    @Getter
    Header header;
    @FindBy(css = "div#box-category-tree > .title")
    private WebElement categoryTitle;
    @FindBy(css = "div#box-account-login > h2")
    private WebElement signInTitle;

    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new Header();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomePage openPage() {
        log.info("Opening page: " + HOME_URL);
        driver.navigate().to(HOME_URL);
        return this;
    }

    public Map<String, String> getFooterLinksTextAndPageTitlesTheyOpen() {
        log.info("Opening Footer links and collecting Footer Link Texts and pages they open");
        return WebElementUtils.getLinkTextAndCorrespondingPageTitlesTheyOpen(footerLinks, driver);
    }

    public List<WebElement> getEssentialWebElementsList() {
        essentialElements = new LinkedList<>();
        essentialElements.add(header.getSelectedLanguage());
        essentialElements.add(header.getChangeRegionalSettingsButton());
        essentialElements.add(header.getShoppingCartTitle());
        essentialElements.add(categoryTitle);
        essentialElements.add(signInTitle);
        return essentialElements;
    }

    public List<String> getEssentialElementsTextAsList(){
        return WebElementUtils.getElementsTextAsList(getEssentialWebElementsList());
    }


}
