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
final class ElementFinder
{
    private final WebDriver driver;

    ElementFinder(WebDriver driver)
    {
        this.driver = Objects.requireNonNull(driver);
    }

    @Nonnull
    WebElement findByXPath(String xpathExpression) {
        return driver.findElement(By.xpath(Objects.requireNonNull(xpathExpression)));
    }
}
