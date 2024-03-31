package org.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.SitePage;

import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SiteTest {

    SitePage site = new SitePage();

    @Test
    public void testPageUrlAndTitle() {
        site.open().assertUrl("https://selenide.org/");

        String title = title();
        Assertions.assertEquals(title, "Selenide: concise UI tests in Java");
    }

    @Test
    public void testInteractingWithElements() {
        open("https://selenide.org/");

        site.getStartedBtn().click();

        String url = WebDriverRunner.url();
        Assertions.assertTrue(url.contains("selenide"));

        site.headingTitle().shouldHave(text("Far from here now"));
    }

    @Test
    public void pageObjectTest() {
        open("https://selenide.org/");

        List<String> expectedLinks = List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes");
        site.linksList().shouldHave(CollectionCondition.texts(expectedLinks));
    }
}
