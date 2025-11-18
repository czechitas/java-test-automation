package cz.czechitas.automation;
import org.junit.jupiter.api.Test;

import java.util.Map;

final class CreateApplicationAsParent extends TestRunner {

        Map<String, String> credentials = Map.of(
                "masterEmail", "ladymaster@gmail.com",
                "masterPassword","Lady123",
                "masterName", "Lady Galadriel",
                "parentEmail", "3e6pa+sprint@protonmail.com",
                "parentPassword", "A1sdfg",
                "parentName", "John Baggins"
        );
        Map <String, String> application = Map.of(
                "termHappy", "02.02. - 06.02.2026"

        );

        @Test
        void smokePageUrlTest() {
            browser.headerMenu.goToHomePage();
            asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/");
        }
        @Test
        void createApplicationRequiredFieldsHappyTest() {

            var firstName = browser.generateRandomName(6);
            var lastName = browser.generateRandomName(8);
            Map<String, String> newApplicationData = Map.of(
                    "term", "02.02. - 06.02.2026",
                    "firstName", firstName,
                    "lastName", lastName,
                    "birthday", "15.12.2015",
                    "paymentMethod", "Hotově"
            );
            logIn(credentials.get("parentEmail"), credentials.get("parentPassword"), credentials.get("parentName"));

            browser.waitFor(2);
            browser.applicationSection.clickCreateNewApplicationButton();
            browser.waitFor(2);
            browser.applicationSection.selectProgrammingSection();
            browser.applicationSection.clickCreatePythonApplicationButton();

            fillOutApplicationForm(newApplicationData);
            browser.waitFor(2);

            asserter.applicationDetailSection.checkTerm(newApplicationData.get("term"));
            asserter.applicationDetailSection.checkFirstName(newApplicationData.get("firstName"));
            asserter.applicationDetailSection.checkLastName(newApplicationData.get("lastName"));
            asserter.applicationDetailSection.checkDateOfBirth(newApplicationData.get("birthday"));
            asserter.applicationDetailSection.checkPaymentMethod(newApplicationData.get("paymentMethod"));
        }
    @Test
    void createApplicationHappyTest() {
        var firstName = browser.generateRandomName(6);
        var lastName = browser.generateRandomName(8);
        var note = browser.generateRandomName(25);
        var healthDisabilityNote = browser.generateRandomName(25);

        Map<String, String> applicationData = Map.of(

                "term", "02.02. - 06.02.2026",
                "firstName", firstName,
                "lastName", lastName,
                "birthday", "15.12.2015",
                "note", note,
                "paymentMethod", "Bankovní převod",
                "healthDisability", "ano",
                "healthDisabilityNote", healthDisabilityNote
        );
        logIn(credentials.get("parentEmail"), credentials.get("parentPassword"), credentials.get("parentName"));

        browser.waitFor(2);
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.waitFor(2);
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();

        fillOutApplicationForm(applicationData);
        browser.waitFor(2);

        asserter.applicationDetailSection.checkTerm(applicationData.get("term"));
        asserter.applicationDetailSection.checkFirstName(applicationData.get("firstName"));
        asserter.applicationDetailSection.checkLastName(applicationData.get("lastName"));
        asserter.applicationDetailSection.checkDateOfBirth(applicationData.get("birthday"));
        asserter.applicationDetailSection.checkPaymentMethod(applicationData.get("paymentMethod"));
        asserter.applicationDetailSection.checkNote(applicationData.get("note"));
        asserter.applicationDetailSection.checkHealthDisabilityNote(applicationData.get("healthDisabilityNote"));

        //browser.loginSection.logout();
    }

    @Test
    void studentYoungerThan4() {
        var firstName = browser.generateRandomName(8);
        var lastName = browser.generateRandomName(10);
        var note = browser.generateRandomName(35);
        var healthDisabilityNote = browser.generateRandomName(42);

        Map<String, String> applicationData = Map.of(

                "term", "28.11.2025",
                "firstName", firstName,
                "lastName", lastName,
                "birthday", "29.11.2021",
                "paymentMethod", "Bankovní převod"
        );
        logIn(credentials.get("parentEmail"), credentials.get("parentPassword"), credentials.get("parentName"));

        browser.waitFor(2);
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.waitFor(2);
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();

        fillOutApplicationForm(applicationData);
        browser.waitFor(2);

        //asserter.
        //browser.loginSection.logout();
    }

    // FUnctions
    void logIn(String email, String password, String name) {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail(email);
        browser.loginSection.insertPassword(password);
        browser.loginSection.clickLoginButton();
        asserter.loginSection.checkUserIsLoggedIn(name);
        //asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/zaki");
    }

        void fillOutApplicationForm(Map<String, String> applicationData) {
            browser.applicationDetailsSection.selectTerm(applicationData.get("term"));
            browser.applicationDetailsSection.insertStudentFirstName(applicationData.get("firstName"));
            browser.applicationDetailsSection.insertStudentLastName(applicationData.get("lastName"));
            browser.applicationDetailsSection.insertBirthdate(applicationData.get("birthday"));
            if (applicationData.containsKey("note")) {
                browser.applicationDetailsSection.insertNote(applicationData.get("note"));
            }
            browser.applicationDetailsSection.clickAcceptTermsCheckbox();
            switch (applicationData.get("paymentMethod")) {
                case "Hotově":
                    browser.applicationDetailsSection.selectCashPaymentMethod();
                    break;
                case "Bankovní převod":
                    browser.applicationDetailsSection.selectBankTransferPaymentMethod();
                    break;
                case "FKSP":
                    browser.applicationDetailsSection.selectFKSPPaymentMethod();
                    break;
                case "Složenka":
                    browser.applicationDetailsSection.selectSlipPaymentMethod();
                    break;
            }
            switch (applicationData.get("healthDisability")) {
                case "ano":
                    browser.applicationDetailsSection.clickHealthDisabilityCheckbox();
                    browser.waitFor(1);
                    browser.applicationDetailsSection.insertHealthDisabilityNote(applicationData.get("healthDisabilityNote"));
                    break;
            }
            browser.applicationDetailsSection.clickCreateApplicationButton();
        }

}
