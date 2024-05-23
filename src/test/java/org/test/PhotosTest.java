package org.test;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MainPage;
import pages.PhotosPage;

import java.util.logging.Logger;

public class PhotosTest extends BaseTest {
    private static Logger logger = Logger.getLogger(LoginTest.class.getName());

    private final static String NICKNAME = "technopol39 technopol39";

    @BeforeAll
    public static void setUpBeforeClass() {
        logger.info("Logging");
        LoginPage loginPage = new LoginPage();
        user = loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    @DisplayName("Testing correct upload photo")
    public void testUploadPhoto() {
        PhotosPage photosPage = new PhotosPage();
        Assertions.assertTrue(photosPage.openPhotoPage().uploadPhoto(), "Photo upload failed");
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
