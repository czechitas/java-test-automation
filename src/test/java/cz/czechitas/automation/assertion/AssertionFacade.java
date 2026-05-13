package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;
import cz.czechitas.automation.ElementFinderInterface;
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

    private final ElementFinderInterface elementFinder;
    public final ApplicationAssertion applicationSection;
    public final ApplicationDetailAssertion applicationDetailsSection;
    public final LoginAssertion loginSection;
    public final HomePageAssertion homePageSection;
    public final GeneralAssertion generalSection;

    public AssertionFacade(WebDriver webDriver) {
        var elementFinder = new ElementFinder(webDriver);
        this.elementFinder = elementFinder;
        this.applicationSection = new ApplicationAssertion(elementFinder);
        this.applicationDetailsSection = new ApplicationDetailAssertion(elementFinder);
        this.loginSection = new LoginAssertion(elementFinder);
        this.homePageSection = new HomePageAssertion(elementFinder);
        this.generalSection = new GeneralAssertion(elementFinder);
    }

    public void checkPageUrl(String url) {
        var urlElement = elementFinder.findByXPath("//a[text()='www.czechitas.cz']");
        assertThat(urlElement.getText()).isEqualTo(url);
    }

    public void checkIsLoggedIn() {
        var loggedInText = elementFinder.findByCssSelector(".navbar-right span");
        assertThat(loggedInText.getText()).isEqualTo("Přihlášen");
    }

    public void checkProgrammingSectionPresence() {
        var programmingText = elementFinder.findByCssSelector(".main_content .card-img-overlay");
        assertThat(programmingText.getText().trim()).isEqualTo("Programování");
    }

    public void checkRegistrationButtonPresence() {
        var registerButton = elementFinder.findByCssSelector(".btn-secondary");
        assertThat(registerButton.getText().trim()).isEqualTo("Zaregistrujte se");
    }
}
