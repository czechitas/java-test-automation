package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;
import org.openqa.selenium.WebDriver;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Assertion facade for user-friendly assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class AssertionFacade {

    private final ElementFinder elementFinder;
    public final ApplicationAssertion applicationSection;
    public final ApplicationDetailAssertion applicationDetailSection;

    public AssertionFacade(WebDriver webDriver)
    {
        this.elementFinder = new ElementFinder(webDriver);
        this.applicationSection = new ApplicationAssertion(elementFinder);
        this.applicationDetailSection = new ApplicationDetailAssertion(elementFinder);
    }

    public void checkPageUrl(String url) {
        var urlElement = elementFinder.findByXPath("//a[text()='www.czechitas.cz']");
        assertThat(urlElement.getText()).isEqualTo(url);
    }

    public void checkIsLoggedIn() {
        var loggedInText = elementFinder.findByCssSelector(".navbar-right span");
        assertThat(loggedInText.getText()).isEqualTo("Přihlášen");
    }

    public void checkProgrammingSectionPresense() {
        var programmingText = elementFinder.findByCssSelector(".main_content .card-img-overlay");
        assertThat(programmingText.getText().trim()).isEqualTo("Programování");
    }

    public void checkRegistrationButtonPresense() {
        var registerButton = elementFinder.findByCssSelector(".btn-secondary");
        assertThat(registerButton.getText().trim()).isEqualTo("Zaregistrujte se");
    }
}
