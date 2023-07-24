package cz.czechitas.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Class that is responsible for finding of the web elements
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class ElementFinder {

    private final WebDriver driver;

    public ElementFinder(WebDriver driver)
    {
        this.driver = Objects.requireNonNull(driver);
    }

    /**
     * Finds {@link WebElement} by XPath
     *
     * @param xpathExpression element XPath
     * @return found {@link WebElement}
     */
    @Nonnull
    public WebElement findByXPath(String xpathExpression) {
     return driver.findElement(By.xpath(Objects.requireNonNull(xpathExpression)));
    }

    /**
     * Finds {@link WebElement} by cssSelector
     *
     * @param cssSelector element css selector
     * @return found {@link WebElement}
     */
    @Nonnull
    public WebElement findByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(Objects.requireNonNull(cssSelector)));
    }
}
