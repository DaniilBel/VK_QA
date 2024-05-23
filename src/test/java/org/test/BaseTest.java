package org.test;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.UserPage;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    private final static String URL = "https://vk.com/";
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    protected static WebDriver driver;

//    protected final static String LOGIN = "technopol39";
    protected final static String LOGIN = "danya.belyaev@gmail.com";
//    protected final static String PASSWORD = "technopolisPassword";
    protected final static String PASSWORD = "ALDA6762alda6762";

    protected static UserPage user;

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
