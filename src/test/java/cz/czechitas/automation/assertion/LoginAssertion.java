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
public final class LoginAssertion {

    private final ElementFinder elementFinder;

    public LoginAssertion(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkRegistrationButtonPresence() {
        var registerButton = elementFinder.findByCssSelector(".btn-secondary");
        assertThat(registerButton.getText().trim()).isEqualTo("Zaregistrujte se");
    }
}