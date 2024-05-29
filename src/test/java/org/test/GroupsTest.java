package org.test;

import org.junit.jupiter.api.*;
import pages.GroupsPage;
import pages.LoginPage;

import java.util.logging.Logger;

public class GroupsTest extends BaseTest {
    private static Logger logger = Logger.getLogger(LoginTest.class.getName());
    private GroupsPage groupsPage;

    @BeforeAll
    public static void setUpBeforeClass() {
        logger.info("Logging");
        LoginPage loginPage = new LoginPage();
        user = loginPage.login(LOGIN, PASSWORD);
    }

    @Test
    @DisplayName("Testing correct create group")
    public void testCreateGroup() {
        groupsPage = new GroupsPage();
        Assertions.assertTrue(groupsPage.openGroupspage().createGroup(), "Group was not created");
    }

    @AfterEach
    public void deleteGroup() {
        groupsPage.openGroupspage().deleteGroup();
    }
}
