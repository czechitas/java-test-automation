package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * New Application specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class ApplicationDetail {

    private final ElementFinder elementFinder;

    ApplicationDetail(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void selectTerm(String termin) {
        var dateElement = elementFinder.findByXPath("//button[@data-id='term_id']");
        dateElement.click();
        var option = elementFinder.findByXPath(
                "//div[starts-with(@id,'bs-select')]//span[contains(text(), '" + termin + "')]"
        );
        option.click();
    }

    void insertStudentFirstName(String firstName) {
        var firstNameInput = elementFinder.findByXPath("//*[@id=\"forename\"]");
        firstNameInput.sendKeys(firstName);
    }

    void insertStudentLastName(String lastname) {
        var lastNameInput = elementFinder.findByXPath("//*[@id=\"surname\"]");
        lastNameInput.sendKeys(lastname);
    }

    void insertBirthdate(String birthdate) {
        var birthDate = elementFinder.findByXPath("//*[@id=\"birthday\"]");
        birthDate.sendKeys(birthdate);
    }

    void insertNote(String note) {
        var noteInput = elementFinder.findByXPath("//*[@id=\"note\"]");
        noteInput.sendKeys(note);
    }

    void clickAcceptTermsCheckbox() {
        var approvalCheckbox = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/span/label");
        approvalCheckbox.click();
    }

    void clickCreateApplicationButton() {
        var createButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/input");
        createButton.click();
    }

    void selectCashPaymentMethod() {
        var inCashRadioButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/form/table/tbody/tr[8]/td[2]/span[4]/label");
        inCashRadioButton.click();
    }

    void selectBankTrasnferPaymentMethod() {
        var toBankAccountButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/form/table/tbody/tr[7]/td[2]/span[1]/label");
        toBankAccountButton.click();
    }

    void clickEditApplicationButton() {
        var editButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/form/table/tbody/tr[10]/td[2]/input");
        editButton.click();
    }
}
