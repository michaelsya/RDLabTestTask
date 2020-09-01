package Pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
    {
        WebDriver driver;

        protected abstract AbstractPage openPage();
        protected final int WAIT_TIMEOUT_SECONDS = 10;

        AbstractPage(WebDriver driver)
        {
            this.driver = driver;
        }
    }

