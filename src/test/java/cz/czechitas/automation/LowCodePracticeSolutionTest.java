package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Class with example solutions of tasks from the Low-code_automation_practice.pdf file
 *
 * @author Jiri Koudelka & Barbora Blozonova
 * @since 1.0.0
 */
final class LowCodePracticeSolutionTest extends TestRunner {

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
        browser.orderSection.insertICO("22834958");
    }

    @Test
    void navigation6() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("muj@tester.cz");
        browser.loginSection.insertPassword("JTester123");
        browser.loginSection.clickLoginButton();

        browser.headerMenu.goToCreateApplicationSection();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
    }

    @Test
    void asserts1() {
        asserter.checkProgrammingSectionPresence();
    }

    @Test
    void asserts2() {
        browser.headerMenu.goToCreateApplicationSection();
        asserter.checkRegistrationButtonPresence();
    }

    @Test
    void asserts3() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("muj@tester.cz");
        browser.loginSection.insertPassword("JTester123");
        browser.loginSection.clickLoginButton();

        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.openFirstApplicationDetailsPage();

        asserter.applicationDetailSection.checkTerm("20.07. - 24.07.2026");
        asserter.applicationDetailSection.checkFirstName("Henry");
        asserter.applicationDetailSection.checkLastName("Proper");
        asserter.applicationDetailSection.checkDateOfBirth("01.01.1990");
        asserter.applicationDetailSection.checkPaymentMethod("Hotově");
    }
}
