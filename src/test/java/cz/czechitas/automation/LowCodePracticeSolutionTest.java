package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Class with example solutions of tasks from the Low-code_automation_practice.pdf file
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class LowCodePracticeSolutionTest extends TestRunner {

    @Test
    void navigation1()
    {
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
    }

    @Test
    void navigation2()
    {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.selectSchoolInNatureOption();
    }

    @Test
    void navigation3()
    {
        browser.headerMenu.goToCreateApplicationSection();
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.headerMenu.goToContactsSection();
        browser.headerMenu.goToHomePage();
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
        browser.headerMenu.goToInstructionsAndFormsForTeacherSection();
    }

    @Test
    void navigation4()
    {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO("22834958");
    }

    @Test
    void navigation6()
    {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();

        browser.headerMenu.goToCreateApplicationSection();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
    }

    @Test
    void asserts1()
    {
        asserter.checkProgrammingSectionPresense();
    }

    @Test
    void asserts2()
    {
        browser.headerMenu.goToCreateApplicationSection();
        asserter.checkRegistrationButtonPresense();
    }

    @Test
    void asserts3()
    {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();

        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.openFirstApplicationDetailsPage();

        asserter.applicationDetailSection.checkTerm("05.02. - 09.02.2024");
        asserter.applicationDetailSection.checkFirstName("Pan");
        asserter.applicationDetailSection.checkLastName("Testerek");
        asserter.applicationDetailSection.checkDateOfBirth("12.03.1999");
        asserter.applicationDetailSection.checkPaymentMethod("Bankovní převod");
    }
}
