package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AvatarPage extends BasePage {
    private static final SelenideElement menu = $(byXpath(".//*[@data-l='t,shortcutMenu']"));

    private static final By DELETE_AVATAR_BUTTON = byText("Убрать фото профиля");

    public AvatarPage() {
        check();
    }

    public void check() throws Error {
        menu.$(DELETE_AVATAR_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка удаления аватара"));
    }
}
