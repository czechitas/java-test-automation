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
}
