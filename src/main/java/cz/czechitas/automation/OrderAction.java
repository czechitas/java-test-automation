package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Public order selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class OrderAction {

    private final ElementFinder elementFinder;

    OrderAction(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void vyberMoznostPrimestskyTabor() {
        var suburbanCampButton = elementFinder.findByXPath("//*[@id=\"nav-home-tab\"]");
        suburbanCampButton.click();
    }

    void vyberMoznostSkolaVPrirode() {
        var schoolInNatureButton = elementFinder.findByXPath("//*[@id=\"nav-profile-tab\"]");
        schoolInNatureButton.click();
    }

    void vyplnICO(String ico) {
        Objects.requireNonNull(ico);

        var icoInputBox = elementFinder.findByXPath("//*[@id=\"ico\"]");
        icoInputBox.sendKeys(ico);
        var fullAddressElement = elementFinder.findByXPath("//*[@id=\"address\"]");
        fullAddressElement.click();
    }

    void vyplnPocetDeti(int pocetDeti) {
        var natureStudentsInput = elementFinder.findByXPath("//*[@id=\"nature-students\"]");
        natureStudentsInput.sendKeys(String.valueOf(pocetDeti));
    }
}
