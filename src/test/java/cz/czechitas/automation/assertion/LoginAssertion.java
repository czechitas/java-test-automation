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
public final class LoginAssertion {

    private final ElementFinder elementFinder;
    private final ApplicationAssertion applicationAssertion;

    public LoginAssertion(ElementFinder elementFinder, ApplicationAssertion applicationAssertion) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
        this.applicationAssertion = Objects.requireNonNull(applicationAssertion);
    }

    public void checkRegistrationButtonPresence() {
        var registerButton = elementFinder.findByCssSelector(".btn-secondary");
        assertThat(registerButton.getText().trim()).isEqualTo("Zaregistrujte se");
    }

    public void checkUserIsLoggedIn(String username) {
        applicationAssertion.checkIsLoggedIn();
        var loggedInText = elementFinder.findByXPath("/html/body/div/header/nav/div/div[2]/div/a/strong");
        assertThat(loggedInText.getText()).contains(username);
    }

    public void checkUserIsNotLoggedIn() {
        var loggedInText = elementFinder.findByXPath("/html/body/div/header/nav/div/div[2]/a");
        assertThat(loggedInText.getText()).isEqualTo("Přihlásit");
    }

    public void checkErrorMessage() {
        var errorMessage = elementFinder.findByCssSelector(".invalid-feedback > strong:nth-child(1)");
        assertThat(errorMessage.getText()).isEqualTo("Tyto přihlašovací údaje neodpovídají žadnému záznamu.");
    }
}