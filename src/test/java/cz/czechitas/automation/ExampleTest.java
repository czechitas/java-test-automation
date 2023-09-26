package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

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
        asserter.checkPageUrl("www.czechitas.cz");
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
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Mtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        asserter.applicationSection.checkColumnExists("Jméno");
        asserter.applicationSection.checkColumnExists("Kategorie");
    }

    @Test
    void complexTaskOne() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Mtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("21.11. - 30.11.2022");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        browser.applicationDetailsSection.insertStudentLastName("Tester001");
        browser.applicationDetailsSection.insertBirthdate("29.01.2000");
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.insertNote("Moje super poznamka");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        asserter.applicationDetailAction.checkPaymentMethod("Hotově");
        asserter.applicationDetailAction.checkFirstName("Pan");
        asserter.applicationDetailAction.checkLastName("Tester001");
        asserter.applicationDetailAction.checkDateOfBirth("29.01.2000");
        asserter.applicationDetailAction.checkNote("Moje super poznamka");
    }

    @Test
    void complexTaskThree() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Mtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search("tester001");
        browser.applicationSection.clickEditFirstApplicationButton();
        browser.applicationDetailsSection.selectBankTrasnferPaymentMethod();
        browser.applicationDetailsSection.clickEditApplicationButton();
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailAction.checkPaymentMethod("Bankovní převod");
        asserter.applicationDetailAction.checkRemainingAmountToPay("1 800 Kč");
        asserter.applicationDetailAction.checkMessageContainsStudentLastName("Tester001");
    }

    @Test
    void complexTaskSix() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Mtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("123");
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
        browser.loginSection.insertPassword("Jtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);
        asserter.applicationSection.checkApplicationsTableIsEmpty();
    }

    @Test
    void complexTaskSeven() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Mtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword("Aaabbb123");
        browser.profileSection.insertPasswordVerification("Aaabbb123");
        browser.profileSection.clickChangeButton();
        browser.waitFor(10);
        browser.loginSection.logout();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Aaabbb123");
        browser.loginSection.clickLoginButton();
        asserter.checkIsLoggedIn();
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword("Mtester123");
        browser.profileSection.insertPasswordVerification("Mtester123");
        browser.profileSection.clickChangeButton();
    }
}
