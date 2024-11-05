package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Class with example solutions of tasks from the Low-code_automation_practice_II.pdf file
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class LowCodePracticeTwoSolutionTest extends TestRunner {

    @Test
    void contactsPageUrlTest() {
        browser.headerMenu.goToContactsSection();
        asserter.generalSection.checkPageUrl("www.czechitas.cz");
    }

    @Test
    void navigationTaskOne() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO("22834958");
        browser.orderSection.selectSchoolInNatureOption();
        browser.orderSection.insertChildrenCount(5);
    }

    @Test
    void assertionTaskOne() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        asserter.applicationSection.checkColumnExists("Jméno");
        asserter.applicationSection.checkColumnExists("Kategorie");
    }

    @Test
    void complexTaskOne() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
        browser.applicationDetailsSection.selectTerm("20.01. - 24.01.2025");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        browser.applicationDetailsSection.insertStudentLastName("Tester001");
        browser.applicationDetailsSection.insertBirthdate("29.01.2000");
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.insertNote("Moje super poznamka");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        asserter.applicationDetailSection.checkPaymentMethod("Hotově");
        asserter.applicationDetailSection.checkFirstName("Pan");
        asserter.applicationDetailSection.checkLastName("Tester001");
        asserter.applicationDetailSection.checkDateOfBirth("29.01.2000");
        asserter.applicationDetailSection.checkNote("Moje super poznamka");
    }

    @Test
    void complexTaskThree() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search("tester001");
        browser.applicationSection.clickEditFirstApplicationButton();
        browser.applicationDetailsSection.selectBankTransferPaymentMethod();
        browser.applicationDetailsSection.clickEditApplicationButton();
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailSection.checkPaymentMethod("Bankovní převod");
        asserter.applicationDetailSection.checkRemainingAmountToPay("1 800 Kč");
        asserter.applicationDetailSection.checkMessageContainsStudentLastName("Tester001");
    }

    @Test
    void complexTaskSix() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
        browser.applicationDetailsSection.selectTerm("20.01. - 24.01.2025");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        var generated = browser.generateRandomName(15);
        browser.applicationDetailsSection.insertStudentLastName(generated);
        browser.applicationDetailsSection.insertBirthdate("11.12.2000");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);
        asserter.applicationSection.checkNumberOfApplications(1);
        browser.loginSection.logout();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ja@tester.cz");
        browser.loginSection.insertPassword("JTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);
        asserter.applicationSection.checkApplicationsTableIsEmpty();
    }

    @Test
    void complexTaskSeven() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword("Aaabbb123");
        browser.profileSection.insertPasswordVerification("Aaabbb123");
        browser.profileSection.clickChangeButton();
        browser.waitFor(10);
        browser.loginSection.logout();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptester@test.cz");
        browser.loginSection.insertPassword("Aaabbb123");
        browser.loginSection.clickLoginButton();
        asserter.applicationSection.checkIsLoggedIn();
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword("PTester123");
        browser.profileSection.insertPasswordVerification("PTester123");
        browser.profileSection.clickChangeButton();
    }
}
