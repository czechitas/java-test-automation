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
        var paymentMethodElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[2]/td[2]/strong");
        assertThat(paymentMethodElement.getText()).isEqualTo(paymentMethod);
    }

    public void checkFirstName(String firstname) {
        var firstNameElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[6]/td[2]");
        assertThat(firstNameElement.getText()).isEqualTo(firstname);
    }

    public void checkLastName(String lastname) {
        var lastNameElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[7]/td[2]");
        assertThat(lastNameElement.getText()).isEqualTo(lastname);
    }

    public void checkDateOfBirth(String birthdate) {
        var birthDateElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[8]/td[2]");
        assertThat(birthDateElement.getText()).isEqualTo(birthdate);
    }

    public void checkNote(String note) {
        var noteElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[10]/td[2]");
        assertThat(noteElement.getText()).isEqualTo(note);
    }

    public void checkRemainingAmountToPay(String paymentAmount) {
        var amountElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[4]/td[2]/strong");
        assertThat(amountElement.getText()).isEqualTo(paymentAmount);
    }

    public void checkMessageContainsStudentLastName(String lastname) {
        var recipientMessageElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[7]/td[2]");
        assertThat(recipientMessageElement.getText()).contains(lastname);
    }

    public void checkTerm(String term) {
        var dateElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[2]/h4");
        assertThat(dateElement.getText()).contains(term);
    }
}
