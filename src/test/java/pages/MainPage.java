package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private static final By ACCOUNT_FIELD = By.xpath("//div[@class='tico ellip']");
    private static final By NEWS_FIELD = By.xpath("//div[@class='tico null']");
//    private static final By HOBBIES_FIELD = By.xpath("//div[@class='nav-side_i  __with-ic __with-new-icons']");
//    private static final By FRIENDS_FIELD = By.xpath("//div[@class='nav-side_i  __with-ic __with-new-icons']");
//    private static final By PHOTO_FIELD = By.xpath("//div[@class='nav-side_i  __with-ic __with-new-icons']");
//    private static final By GROUP_FIELD = By.xpath("//div[@class='nav-side_i  __with-ic __with-new-icons']");

    public MainPage() {
        checkPage();
    }

    public void checkPage() {
        $(ACCOUNT_FIELD).shouldBe(visible.because("Account field should be visible on user main page"));
        $(NEWS_FIELD).shouldBe(visible.because("Other field should be visible on user main page"));
//        $(HOBBIES_FIELD).shouldBe(visible.because("Hobbies field should be visible on user main page"));
//        $(FRIENDS_FIELD).shouldBe(visible.because("Friends field should be visible on user main page"));
//        $(PHOTO_FIELD).shouldBe(visible.because("Photo field should be visible on user main page"));
//        $(GROUP_FIELD).shouldBe(visible.because("Group field should be visible on user main page"));
    }

    public String getNickname() {
        return $(ACCOUNT_FIELD).getText();
    }
}
