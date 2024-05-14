package org.test;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private final static String URL = "https://ok.ru/";
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    protected static WebDriver driver;

    @BeforeAll
    public static void init() {
        logger.info("Initializing test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterAll
    public static void clear() {
        closeWebDriver();
    }
}
