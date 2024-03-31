package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SitePage {
    public SitePage open() {
        Selenide.open("https://selenide.org/");
        return this;
    }

    public SelenideElement getStartedBtn() {
        return $(By.id("selenide-logo"));
    }

    public SelenideElement headingTitle() {
        return $(By.xpath("//div[@class=\"news-line news-link\"]"));
    }

    public ElementsCollection linksList() {
        return $$("header .main-menu-pages a");
    }

    public void assertUrl(String expectedUrl) {
        String url = WebDriverRunner.url();
        Assertions.assertEquals(url, expectedUrl);
    }
}
