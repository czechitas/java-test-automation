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
public final class GeneralAssertion {

    private final ElementFinder elementFinder;

    public GeneralAssertion(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkPageUrl(String url) {
        var urlElement = elementFinder.findByXPath("//a[text()='www.czechitas.cz']");
        assertThat(urlElement.getText()).isEqualTo(url);
    }
}