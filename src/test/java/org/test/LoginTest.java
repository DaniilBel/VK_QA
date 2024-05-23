package org.test;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.UserPage;

import java.util.logging.Logger;

@DisplayName("Testing login page")
public class LoginTest extends BaseTest {

    Logger logger = Logger.getLogger(LoginTest.class.getName());

    private final static String ERR_MES_RUS = "Аккаунт не найден. Повторите попытку или зарегистрируйтесь по номеру телефона";
    private final static String ERR_MES_ENG = "Incorrect username and/or password";
    private UserPage user;

    @Test
    @DisplayName("Testing correct login")
    public void testCorrectLogin() {
        logger.info("Testing correct login");
        LoginPage loginPage = new LoginPage();
        user = loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    @DisplayName("Testing incorrect password")
    public void testIncorrectLogin() {
        logger.info("Testing incorrect password");
        LoginPage loginPage = new LoginPage();
        String errMes = loginPage.setLogin("dan").setPassword(PASSWORD).clickLogin()
                .getErrorMessage();
        Assertions.assertEquals(ERR_MES_RUS, errMes);
    }

    @AfterEach
    public void logout() {
        if (user != null) {
            user.logout();
            user = null;
        }
    }
}
