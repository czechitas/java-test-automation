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
final class NewApplication {

    private final ElementFinder elementFinder;

    NewApplication(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void vyberTermin(String termin) {
        var dateElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/button");
        dateElement.click();
        //TODO: find by parameter instead of selecting first option
        var option = elementFinder.findByXPath("//*[@id=\"bs-select-1-0\"]");
        option.click();
    }

    void vyplnKrestniJmenoZaka(String krestniJmeno) {
        var firstNameInput = elementFinder.findByXPath("//*[@id=\"forename\"]");
        firstNameInput.sendKeys(krestniJmeno);
    }

    void vyplnPrijmeniZaka(String prijmeni) {
        var lastNameInput = elementFinder.findByXPath("//*[@id=\"surname\"]");
        lastNameInput.sendKeys(prijmeni);
    }

    void vyplnDatumNarozeni(String datumNarozeni) {
        var birthDate = elementFinder.findByXPath("//*[@id=\"birthday\"]");
        birthDate.sendKeys(datumNarozeni);
    }

    void vyplnPoznamku(String poznamka) {
        var note = elementFinder.findByXPath("//*[@id=\"note\"]");
        note.sendKeys(poznamka);
    }

    void klikniNaSouhlasSPodminkami() {
        var approvalCheckbox = elementFinder.findByXPath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/span/label");
        approvalCheckbox.click();
    }

    void klikniNaVytvoritPrihlasku() {
        var createButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/input");
        createButton.click();
    }

    void zvolZpusobUhradyHotove() {
        var inCashRadioButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/form/table/tbody/tr[8]/td[2]/span[4]/label");
        inCashRadioButton.click();
    }
}
