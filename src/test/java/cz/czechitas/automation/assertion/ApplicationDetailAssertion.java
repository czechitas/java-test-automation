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

    public void overZpusobUhradyPrihlasky(String zpusobUhrady) {
        var paymentMethodElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[2]/td[2]/strong");
        assertThat(paymentMethodElement.getText()).isEqualTo(zpusobUhrady);
    }

    public void overKrestniJmeno(String krestniJmeno) {
        var firstNameElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[6]/td[2]");
        assertThat(firstNameElement.getText()).isEqualTo(krestniJmeno);
    }

    public void overPrijmeni(String prijmeni) {
        var lastNameElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[7]/td[2]");
        assertThat(lastNameElement.getText()).isEqualTo(prijmeni);
    }

    public void overDatumNarozeni(String datumNarozeni) {
        var birthDateElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[8]/td[2]");
        assertThat(birthDateElement.getText()).isEqualTo(datumNarozeni);
    }

    public void overPoznamku(String poznamka) {
        var noteElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[10]/td[2]");
        assertThat(noteElement.getText()).isEqualTo(poznamka);
    }

    public void overZbyvajiciCastkuKUhrazeni(String castkaKUhrazeni) {
        var amountElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[4]/td[2]/strong");
        assertThat(amountElement.getText()).isEqualTo(castkaKUhrazeni);
    }

    public void overZpravaProPrijemceObsahujePrijmeniZaka(String prijmeniZaka) {
        var recipientMessageElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/table/tbody/tr[7]/td[2]");
        assertThat(recipientMessageElement.getText()).contains(prijmeniZaka);
    }

    public void overTermin(String termin) {
        var dateElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[2]/h4");
        assertThat(dateElement.getText()).contains(termin);
    }
}
