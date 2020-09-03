package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class LoginPage extends BasePage {
    private final String LOGIN_URL = "http://kuopassa.net/litecart/en/login";

    @FindBy(css = "input[name='email']")
    private WebElement emailField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement loginErrorWarning;

    @FindBy(css = "button[name='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successNotification;

    private List<WebElement> essentialLinks;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGIN_URL);
        return this;
    }

    public String getLoginErrorText() {
        String errorMessage = loginErrorWarning.getText();
        log.info("Getting error " + "'" + errorMessage + "'");
        return errorMessage;
    }

    public LoginPage enterEmailAsLogin(String email) {
        log.info("Entering email: " + email);
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        log.info("Entering password: " + password);
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage attemptLogin() {
        log.info("Hitting Login button");
        signInButton.click();
        return this;
    }

    public String getSuccessNotificationText() {
        String successText = successNotification.getText();
        log.info("Getting following success notification: '" + successText + "'");
        return successText;
    }

    public List<WebElement> fillEssentialLinks(){
        essentialLinks.add(signInButton);
        essentialLinks.add(passwordField);
        return essentialLinks;

    }


}
