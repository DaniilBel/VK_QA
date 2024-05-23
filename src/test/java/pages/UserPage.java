package pages;

import blocks.SideBar;
import org.openqa.selenium.By;
import pages.friends.FriendsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends BasePage {
    private static final By NAVIGATION_TOOLBAR = By.xpath("//div[@class='topPanel']");
    private static final By EXIT_BUTTON = By.xpath("//div[@class='toolbar_accounts-user-delete-button']");
    private static final By CONFIRMATION_OF_EXIT_BUTTON = By.xpath("//*[@id='hook_FormButton_logoff.confirm_not_decorate']");
    private static final By NAVIGATION_BAR = By.xpath("//*[@id='hook_Block_SideNavigation']");
    private static final By AVATAR = By.xpath("//div[@class='card_wrp']");
    private static final By PROFILE = By.xpath("//div[@class='toolbar_dropdown_w h-mod']");

    public UserPage() {
        checkPage();
    }

    public void checkPage() {
        $(NAVIGATION_TOOLBAR).shouldBe(visible.because("NavigationToolBar should be visible on user main page"));
        $(NAVIGATION_BAR).shouldBe(visible.because("NavigationBar should be visible on user main page"));
        $(AVATAR).shouldBe(visible.because("AVATAR should be visible on user main page"));
    }

    public void logout() {
        $(PROFILE).shouldBe(visible.because("Profile settings button should be visible before clicking"))
                .click();
        $(EXIT_BUTTON).shouldBe(visible.because("Logout form should be visible"))
                .click();
        $(CONFIRMATION_OF_EXIT_BUTTON).shouldBe(visible.because("Exit button should be visible"))
                .click();
    }
}
