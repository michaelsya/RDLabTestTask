package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    static WebDriver driver = getDriver();

    public static Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(1000))
            .ignoring(org.openqa.selenium.StaleElementReferenceException.class);

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser").toLowerCase()) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                default:
                    throw new DriverNotFoundException(String.format("No browser " +
                            "specified or the browser is not supported. Supported browser arguments: " +
                            "\n firefox \n chrome"));
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
