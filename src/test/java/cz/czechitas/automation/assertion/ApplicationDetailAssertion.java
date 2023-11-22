package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Application specific assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class ApplicationDetailAssertion {

    private final ElementFinder elementFinder;

    public ApplicationDetailAssertion(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkPaymentMethod(String paymentMethod) {
        var paymentMethodElement = elementFinder.findByXPath("//table/tbody//td[text()='Způsoby úhrady kurzu:']/..//strong");
        assertThat(paymentMethodElement.getText()).isEqualTo(paymentMethod);
    }

    public void checkFirstName(String firstname) {
        var firstNameElement = elementFinder.findByXPath("//table/tbody//td[text()='Křestní jméno žáka:']/../td[2]");
        assertThat(firstNameElement.getText()).isEqualTo(firstname);
    }

    public void checkLastName(String lastname) {
        var lastNameElement = elementFinder.findByXPath("//table/tbody//td[text()='Příjmení žáka:']/../td[2]");
        assertThat(lastNameElement.getText()).isEqualTo(lastname);
    }

    public void checkDateOfBirth(String birthdate) {
        var birthDateElement = elementFinder.findByXPath("//table/tbody//td[text()='Datum narození žáka:']/../td[2]");
        assertThat(birthDateElement.getText()).isEqualTo(birthdate);
    }

    public void checkNote(String note) {
        var noteElement = elementFinder.findByXPath("//table/tbody//td[text()='Poznámka:']/../td[2]");
        assertThat(noteElement.getText()).isEqualTo(note);
    }

    public void checkRemainingAmountToPay(String paymentAmount) {
        var amountElement = elementFinder.findByXPath("//table/tbody//td[text()='Zbývá uhradit']/..//strong");
        assertThat(amountElement.getText()).isEqualTo(paymentAmount);
    }

    public void checkMessageContainsStudentLastName(String lastname) {
        var recipientMessageElement = elementFinder.findByXPath("//table/tbody//td[text()='Zpráva pro příjemce']/../td[2]");
        assertThat(recipientMessageElement.getText()).contains(lastname);
    }

    public void checkTerm(String term) {
        var dateElement = elementFinder.findByCssSelector(".card-body h4");
        assertThat(dateElement.getText()).contains(term);
    }

    public void checkIfCancelled() {
        var warning = elementFinder.findByCssSelector(".alert-warning");
        assertThat(warning.getText()).contains("Žák byl odhlášen");
        assertThat(warning.getText()).contains("Z důvodu nemoci");
    }
}
