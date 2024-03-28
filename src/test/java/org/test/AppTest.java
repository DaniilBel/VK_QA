package org.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class AppTest {

    static String url = "";

    @BeforeAll
    public static void setUp() {
        url = "https://google.com/ncr";
    }

    @Test
    public void shouldSearch() {
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        ElementsCollection res = elements("#search .g");
        res.shouldHave(sizeGreaterThanOrEqual(6))
                .first().shouldHave(text("Selenide: concise UI tests in Java"));

//        res.first().find(".r>a").click();
//
//        Wait().until(titleIs("Selenide: concise UI tests in Java"));
    }

    @Test
    public void searchResultsContainSelenide() {
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(0)).forEach(element ->
                element.shouldHave(text("Selenide")));
    }

    @Test
    public void searchResultsContainLinks() {
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(0)).forEach(element ->
                element.find("a").shouldHave(attribute("href")));
    }
}
