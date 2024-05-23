package blocks;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SideBar {
    private static final By profileName = By.xpath("//*[@class='tico ellip']");
    private static final By friendsButton = By.xpath("//*[@id='hook_Block_Navigation']//a[@data-l='t,userFriend']//div");
    private static final By photoButton = By.xpath("//*[@data-l='t,userPhotos']//div[@class='tico null']");
    private static final By groupsButton = By.xpath("//*[@data-l='t,userAltGroup']//div[@class='tico null']");

    public SideBar() {
        checkMenu();
    }

    public void checkMenu() {
        $(friendsButton).shouldBe(visible.because("friends button should be visible on leftMenu"));
        $(profileName).shouldBe(visible.because("profile name should be visible on leftMenu"));
        $(photoButton).shouldBe(visible.because("photoButton should be visible on leftMenu"));
        $(groupsButton).shouldBe(visible.because("groupsButton should be visible on leftMenu"));
    }

    public By getProfileName() {
        return profileName;
    }

    public By getPhotoButton() {
        return photoButton;
    }

    public By getGroupsButton() {
        return groupsButton;
    }
}
