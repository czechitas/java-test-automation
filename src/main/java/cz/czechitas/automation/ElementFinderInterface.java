package cz.czechitas.automation;

import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Used for mocking in testing
 */
@ParametersAreNonnullByDefault
public interface ElementFinderInterface {

    @Nonnull
    WebElement findByXPath(String xpathExpression);

    @Nonnull
    WebElement findByCssSelector(String cssSelector);
}

