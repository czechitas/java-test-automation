package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;
import org.openqa.selenium.WebDriver;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Assertion facade for user-friendly assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class AssertionFacade {

    public final ApplicationAssertion applicationSection;
    public final ApplicationDetailAssertion applicationDetailSection;
    public final LoginAssertion loginAssertion;
    public final HomePageAssertion homePageAssertion;
    public final GeneralAssertion generalAssertion;

    public AssertionFacade(WebDriver webDriver) {
        var elementFinder = new ElementFinder(webDriver);
        this.applicationSection = new ApplicationAssertion(elementFinder);
        this.applicationDetailSection = new ApplicationDetailAssertion(elementFinder);
        this.loginAssertion = new LoginAssertion(elementFinder);
        this.homePageAssertion = new HomePageAssertion(elementFinder);
        this.generalAssertion = new GeneralAssertion(elementFinder);
    }
}
