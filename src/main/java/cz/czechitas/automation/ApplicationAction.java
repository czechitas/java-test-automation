package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Application selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class ApplicationAction {

    private final ElementFinder elementFinder;

    ApplicationAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void klikniNaVytvoreniNovePrihlasky() {
        var createApplicationButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[1]/a");
        createApplicationButton.click();
    }

    void vyberObdobiProgramovani() {
        var programmingSectionButton = elementFinder.findByXPath("/html/body/div/div/div[1]/div[3]/div/div[2]/a");
        programmingSectionButton.click();
    }

    void klikniNaVytvoritPrihlasku() {
        var createApplicationButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/div/div[2]/a");
        createApplicationButton.click();
    }

    void otevriDetailPrvniPrihlasky() {
        var openApplicationButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr/td[5]/div/a[1]");
        openApplicationButton.click();
    }

    void vyhledej(String textKVyhledani) {
        var searchInput = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[1]/div/div[2]/div/label/input");
        searchInput.sendKeys(textKVyhledani);
    }

    void klikniNaUpravitUPrvniPrihlasky() {
        var firstApplicationEditButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[5]/div/a[2]");
        firstApplicationEditButton.click();
    }

    void klikniNaDetailUPrvniPrihlasky() {
        var firstApplicationDetailButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[5]/div/a[1]/i");
        firstApplicationDetailButton.click();
    }
}
