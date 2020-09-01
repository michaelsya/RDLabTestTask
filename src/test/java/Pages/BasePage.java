package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    Logger log = LogManager.getRootLogger();

    @FindBy(xpath = "//footer//li//a")
    List<WebElement> footerLinks;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract BasePage openPage();
}

