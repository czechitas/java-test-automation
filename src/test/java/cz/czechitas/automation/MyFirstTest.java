package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

final class MyFirstTest extends TestRunner {

        private void login() {
            browser.loginSection.clickLoginMenuLink();
            browser.loginSection.insertEmail("manka.rumova@yahoo.com");
            browser.loginSection.insertPassword("Hovinko123");
            browser.loginSection.clickLoginButton();
        }
    @Test
    void navigateToParentInstructionsAndFormsTest() {
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
    }

    @Test
    void orderSuburbanCampTest() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.selectSuburbanCampOption();
    }
    @Test
    void navigateAllMenuSectionsTest() {
        browser.headerMenu.goToHomePage();
        browser.headerMenu.goToContactsSection();
        browser.headerMenu.goToInstructionsAndFormsForParentSection();
        browser.headerMenu.goToCreateApplicationSection();
        browser.headerMenu.goToInstructionsAndFormsForTeacherSection();
        browser.headerMenu.goToKindergartenAndSchoolSection();
    }
    @Test
    void fillICOTest() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        browser.orderSection.insertICO("22834958");
    }
    @Test
    void createApplicationTest() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("manka.rumova@yahoo.com");
        browser.loginSection.insertPassword("Hovinko123");
        browser.loginSection.clickLoginButton();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
    }
    @Test
    void checkProgrammingTileTest() {
        asserter.checkProgrammingSectionPresence();
    }
    @Test
    void checkRegistrationButtonTest() {
        browser.headerMenu.goToCreateApplicationSection();
        asserter.checkRegistrationButtonPresence();
    }
    @Test
    void checkPaymentMethodTest() {
        login();
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailSection.checkPaymentMethod("Bankovní převod");
    }
    @Test
    void orderWithICOAndSchoolInNatureTest() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        asserter.checkPageUrl("www.czechitas.cz");
        browser.orderSection.insertICO("22834958");
        asserter.orderSection.checkIcoFieldContainsValue("22834958");
        browser.orderSection.selectSchoolInNatureOption();
        browser.orderSection.insertChildrenCount(15);
    }
    @Test
    void checkApplicationColumnsTest() {
        login();
        browser.headerMenu.goToApplicationsSection();
        asserter.applicationSection.checkColumnExists("Jméno", "Kategorie");
    }
    @Test
    void complexApplicationTest() {
            login();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
        browser.applicationDetailsSection.selectTerm("08.06. - 19.06.2026");
        browser.applicationDetailsSection.insertStudentFirstName("Jan");
        browser.applicationDetailsSection.insertStudentLastName("Testovaci");
        browser.applicationDetailsSection.insertBirthdate("01.01.2015");
        browser.applicationDetailsSection.insertNote("Testovaci poznamka");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        asserter.applicationDetailSection.checkTerm("08.06. - 19.06.2026");
        asserter.applicationDetailSection.checkFirstName("Jan");
        asserter.applicationDetailSection.checkLastName("Testovaci");
        asserter.applicationDetailSection.checkDateOfBirth("01.01.2015");
        asserter.applicationDetailSection.checkNote("Testovaci poznamka");
    }
    @Test
    void searchAndEditApplicationTest() {
        login();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search("Tester001");
        browser.applicationSection.clickEditFirstApplicationButton();
        browser.applicationDetailsSection.selectBankTransferPaymentMethod();
        browser.applicationDetailsSection.clickEditApplicationButton();
        browser.applicationSection.search("Tester001");
        browser.applicationSection.openFirstApplicationDetailsPage();
        asserter.applicationDetailSection.checkPaymentMethod("Bankovní převod");
        asserter.applicationDetailSection.checkRemainingAmountToPay("2 490 Kč");
        asserter.applicationDetailSection.checkMessageContainsStudentLastName("Tester001");
    }
    @Test
    void twoUsersApplicationTest() {
        // Prihlaseni jako prvni uzivatel
        login();

        // Vygenerovani nahodneho jmena a ulozeni do pormenne
        var randomPrijmeni = browser.generateRandomName(10);

        // Vytvoreni prihlasky
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
        browser.waitFor(3);
        browser.applicationDetailsSection.selectTerm("08.06. - 19.06.2026");
        browser.applicationDetailsSection.insertStudentFirstName("Test");
        browser.applicationDetailsSection.insertStudentLastName(randomPrijmeni);
        browser.applicationDetailsSection.insertBirthdate("01.01.2015");
        browser.applicationDetailsSection.insertNote("test");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();

        // Overeni z eprihlaska existuje
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(randomPrijmeni);
        asserter.applicationSection.checkNumberOfApplications(1);

        // Odhlaseni
        browser.loginSection.logout();

        // Prihlaseni
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("peky@email.cz");
        browser.loginSection.insertPassword("Hovinko123");
        browser.loginSection.clickLoginButton();

        // Overeni z eprihlaska prvniho uzivatele neexistuje
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(randomPrijmeni);
        asserter.applicationSection.checkApplicationsTableIsEmpty();
    }

    @Test
    void changePasswordTest() {
        var noveHeslo = "NoveHeslo123";
        var puvodniHeslo = "Hovinko123";

        // Prihlaseni
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("peky@email.cz");
        browser.loginSection.insertPassword(puvodniHeslo);
        browser.loginSection.clickLoginButton();

        // Zmena hesla
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword(noveHeslo);
        browser.profileSection.insertPasswordVerification(noveHeslo);
        browser.profileSection.clickChangeButton();

        // Prodleva nez zmizi pop up
        browser.waitFor(9);

        // Odhlaseni
        browser.loginSection.logout();

        // Prihlaseni s novym heslem
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("peky@email.cz");
        browser.loginSection.insertPassword(noveHeslo);
        browser.loginSection.clickLoginButton();

        // Overeni prihlaseni
        asserter.checkIsLoggedIn();

        // Zmena hesla zpet na puvodni
        browser.profileSection.goToProfilePage();
        browser.profileSection.insertPassword(puvodniHeslo);
        browser.profileSection.insertPasswordVerification(puvodniHeslo);
        browser.profileSection.clickChangeButton();
    }
}
