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

    void selectTerm(String term) {
        var dateElement = elementFinder.findByXPath("//button[@data-id='term_id']");

        dateElement.click();
        var option = elementFinder.findByXPath(
                "//div[starts-with(@id,'bs-select')]//span[contains(text(), '" + term + "')]"
        );
        option.click();
    }

    void insertStudentFirstName(String firstName) {
        var firstNameInput = elementFinder.findByXPath("//*[@id='forename']");
        firstNameInput.sendKeys(firstName);
    }

    void insertStudentLastName(String lastname) {
        var lastNameInput = elementFinder.findByXPath("//*[@id='surname']");
        lastNameInput.sendKeys(lastname);
    }

    void insertBirthdate(String birthdate) {
        var birthDate = elementFinder.findByXPath("//*[@id='birthday']");
        birthDate.sendKeys(birthdate);
    }

    void insertNote(String note) {
        var noteInput = elementFinder.findByXPath("//*[@id='note']");
        noteInput.sendKeys(note);
    }

    void clickAcceptTermsCheckbox() {
        var approvalCheckbox = elementFinder.findByXPath(
                "//label[@for='terms_conditions']");
        approvalCheckbox.click();
    }

    void clickCreateApplicationButton() {
        var createButton = elementFinder.findByXPath(
                "//input[@type='submit']");
        createButton.click();
    }

    void selectCashPaymentMethod() {
        var inCashRadioButton = elementFinder.findByXPath(
                "//label[@for='payment_cash']");
        inCashRadioButton.click();
    }

    void selectBankTransferPaymentMethod() {
        var toBankAccountButton = elementFinder.findByXPath(
                "//label[@for='payment_transfer']");
        toBankAccountButton.click();
    }

    void clickEditApplicationButton() {
        var editButton = elementFinder.findByXPath(
                "//input[@value='Upravit přihlášku']");
        editButton.click();
    }
}
