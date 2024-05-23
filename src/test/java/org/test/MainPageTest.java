package org.test;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MainPage;

import java.util.logging.Logger;

public class MainPageTest extends BaseTest {
    private static Logger logger = Logger.getLogger(LoginTest.class.getName());

    private final static String NICKNAME = "technopol39 technopol39";

    @BeforeAll
    public static void setUpBeforeClass() {
        logger.info("Logging");
        LoginPage loginPage = new LoginPage();
        user = loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    @DisplayName("Testing correct main page elements")
    public void testCorrectNickname() {
        MainPage mainPage = new MainPage();
        Assertions.assertEquals(mainPage.getNickname(), NICKNAME);
    }

    @AfterAll
    public static void tearDownAfterClass() {
        logger.info("Logged out");
        if (user != null) {
            user.logout();
            user = null;
        }
    }
}
