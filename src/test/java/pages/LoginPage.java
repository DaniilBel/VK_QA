package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final static By LOGIN_FIELD = By.xpath("//*[@id='field_email']");
    private final static By PASSWORD_FIELD = By.xpath("//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@class='button-pro __wide']");
    private final static By ERROR_MESSAGE = By.xpath(".//*[@class='input-e login_error']");

    public LoginPage() {
        checkPage();
    }

    @Override
    public void checkPage() {
        $(LOGIN_FIELD).shouldBe(visible.because("Login field should be visible"));
        $(PASSWORD_FIELD).shouldBe(visible.because("Password field should be visible"));
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible"));
    }

    public LoginPage setLogin(String login) {
        $(LOGIN_FIELD).shouldBe(enabled.because("Login should be enabled"))
                .val(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(PASSWORD_FIELD).shouldBe(enabled.because("Password should be enabled"))
                .val(password);

        return this;
    }

    public LoginPage clickLogin() {
        $(LOGIN_BUTTON).shouldBe(and("Button should be enabled", enabled, visible))
                .click();

        return this;
    }

    public UserPage login(String login, String password) {
        setLogin(login).setPassword(password).clickLogin();
        return new UserPage();
    }

    public String getErrorMessage() {
        return $(ERROR_MESSAGE).getText();
    }
}
