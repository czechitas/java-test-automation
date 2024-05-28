package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Application specific assertions
 *
 * @author Adam Abbod
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class HomePageAssertion {

    private final ElementFinder elementFinder;

    public HomePageAssertion(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkProgrammingSectionPresence() {
        var programmingText = elementFinder.findByCssSelector(".main_content .card-img-overlay");
        assertThat(programmingText.getText().trim()).isEqualTo("Programování");
    }
}