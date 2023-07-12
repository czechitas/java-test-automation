package cz.czechitas.automation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Example test class for functionality showcase
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class ExampleTest extends TestRunner {

    @Test
    void contactsPageUrlTest() {
        browser.headerMenu.gotoContactsSection();
        asserter.checkPageUrl("www.czechitas.cz");
    }

    @Test
    void successfulLoginTest() {
        browser.loginAction.clickLoginMenuLink();
        browser.loginAction.insertEmail("da-app.admin@czechitas.cz");
        browser.loginAction.insertPassword("Czechitas123");
        browser.loginAction.clickLoginButton();
        asserter.checkIsLoggedIn();
    }

    // paramertized test - find out what is wrong with this test
    @ParameterizedTest()
    @ValueSource(strings = {"123456789", "ASDFBVC", "123"})
    void icoFieldTest(String icoValue) {
        browser.headerMenu.gotoKindergartenAndSchoolSection();
        browser.orderAction.insertICO(icoValue);
    }
}
