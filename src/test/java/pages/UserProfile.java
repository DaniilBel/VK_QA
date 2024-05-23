package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserProfile extends BasePage {
    private static final By SETTINGS_BUTTON = byXpath(".//*[@data-l='outlandertarget,settings,t,settings']");

    public UserProfile() {
        check();
    }

    public void check() throws Error {
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек"));
    }
}
