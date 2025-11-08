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
        browser.headerMenu.goToContactsSection();
        asserter.generalSection.checkPageUrl("www.czechitas.cz");
    }

    @Test
    void successfulLoginTest() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("da-app.admin@czechitas.cz");
        browser.loginSection.insertPassword("Czechitas123");
        browser.loginSection.clickLoginButton();
        asserter.applicationSection.checkIsLoggedIn();
    }

    // paramertized test - find out what is wrong with this test
    @ParameterizedTest()
    @ValueSource(strings = {"123456789", "ASDFBVC", "123"})
    void icoFieldTest(String icoValue) {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO(icoValue);
    }

    @Test
    void navigation1()
    {
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
    }

    @Test
    void navigation2() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.selectSchoolInNatureOption();
    }

    @Test
    void navigation3() {
        browser.headerMenu.goToCreateApplicationSection();
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.headerMenu.goToContactsSection();
        browser.headerMenu.goToHomePage();
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
        browser.headerMenu.goToInstructionsAndFormsForTeacherSection();
    }

    @Test
    void navigation4() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO("1234566");
    }

    @Test
    void navigation6() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptestak@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();

        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
    }
}
