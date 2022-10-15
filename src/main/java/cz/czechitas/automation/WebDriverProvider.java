package cz.czechitas.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

/**
 * WebDriver provider that creates instances of {@link WebDriver} based on the following priorities:
 *  Firefox
 *  Chrome
 *  Edge
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
public final class WebDriverProvider {

    private WebDriverProvider() {
        throw new UnsupportedOperationException("Unable to instantiate class with only static methods.");
    }

    /**
     * Get new instance of the selenium {@link WebDriver}.
     * The given instance is dependent on web browsers installed on your computer and
     * is created in the following priority:
     *  - Firefox
     *  - Chrome
     *  - Edge
     *
     * @return web driver instance
     */
    @Nonnull
    public static WebDriver getWebDriver() {
        try {
            return WebDriverManager.firefoxdriver().create();
        } catch (WebDriverManagerException exception) {
            return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        try {
            return WebDriverManager.chromedriver().create();
        } catch (WebDriverManagerException exception1) {
            return createEdgeDriver();
        }
    }

    private static WebDriver createEdgeDriver() {
        return WebDriverManager.edgedriver().create();
    }
}
