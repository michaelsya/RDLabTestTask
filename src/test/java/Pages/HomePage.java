package Pages;

import Utils.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class HomePage extends BasePage {
    private final String HOME_URL = "http://kuopassa.net/litecart/en/";

    public HomePage(WebDriver driver) {
        super(driver);
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

}
