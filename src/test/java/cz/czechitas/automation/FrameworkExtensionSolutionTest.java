package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Test class for the solution of the framework extension
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class FrameworkExtensionSolutionTest extends TestRunner {

    @Test
    void cancelApplicationDueToSickness() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptestak@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
        browser.applicationDetailsSection.selectTerm("02.02. - 06.02.2026");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        var generated = browser.generateRandomName(15);
        browser.applicationDetailsSection.insertStudentLastName(generated);
        browser.applicationDetailsSection.insertBirthdate("11.12.2000");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);

        browser.applicationSection.clickCancelFirstApplicationButton();
        browser.applicationSection.selectIllnessOption();
        browser.applicationSection.clickCancelApplicationButton();

        browser.applicationSection.openFirstApplicationDetailsPage();

        asserter.applicationDetailSection.checkCancellationMessage("nemoci");
    }

    @Test
    void cancelApplicationDueToOtherReason() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ptestak@test.cz");
        browser.loginSection.insertPassword("PTester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreatePythonApplicationButton();
        browser.applicationDetailsSection.selectTerm("02.02. - 06.02.2026");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        var generated = browser.generateRandomName(15);
        browser.applicationDetailsSection.insertStudentLastName(generated);
        browser.applicationDetailsSection.insertBirthdate("11.12.2000");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);

        browser.applicationSection.clickCancelFirstApplicationButton();
        browser.applicationSection.selectOtherReasonOption();
        browser.applicationSection.insertReason("To je důvod");
        browser.applicationSection.clickCancelApplicationButton();

        browser.applicationSection.openFirstApplicationDetailsPage();

        asserter.applicationDetailSection.checkCancellationMessage("To je důvod");
    }
}
