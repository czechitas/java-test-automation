package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinderInterface;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@ParametersAreNonnullByDefault
public class OrderAssertion {

    private final ElementFinderInterface elementFinder;

    OrderAssertion(ElementFinderInterface elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkIcoFieldContainsValue(String ico) {
        var icoField = elementFinder.findByCssSelector("#ico");
        assertThat(icoField.getAttribute("value")).isEqualTo(ico);
    }
}