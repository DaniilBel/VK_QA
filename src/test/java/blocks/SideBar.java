package blocks;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SideBar {
    private final SelenideElement block = $(byId("hook_Block_SideNavigation"));

    private static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");
    private static final By HOME_BUTTON = byText("Лента");
    private static final By FRIENDS_BUTTON = byText("Друзья");

    public void clickOnHome() {
        block.$(HOME_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода на ленту")
        ).click();
    }

    public void clickOnMyProfile() {
        block.$(MY_PROFILE_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода в профиль")
        ).click();
    }

    public void clickOnFriends() {
        block.$(FRIENDS_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода на страницу друзей")
        ).click();
    }
}
