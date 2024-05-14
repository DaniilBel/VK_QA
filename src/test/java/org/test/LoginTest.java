package org.test;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.UserPage;

import java.util.logging.Logger;

@DisplayName("Testing login page")
public class LoginTest extends BaseTest {

    Logger logger = Logger.getLogger(LoginTest.class.getName());

    private final static String LOGIN = "technopol39";
    private final static String PASSWORD = "technopolisPassword";
    private final static String ERR_MES_RUS = "Неправильно указан логин и/или пароль";
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
        String errMes = loginPage.setLogin(LOGIN).setPassword("1234qwer").clickLogin()
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
