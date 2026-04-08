package cz.czechitas.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import javax.annotation.Nonnull;
import java.util.HashMap;

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

    private static final boolean HEADLESS = Boolean.parseBoolean(
            System.getProperty("headless", String.valueOf("true".equalsIgnoreCase(System.getenv("CI"))))
    );

    /**
     * Get new instance of the selenium {@link WebDriver}.
     * The given instance is dependent on web browsers installed on your computer and
     * is created in the following priority:
     *  - Firefox
     *  - Chrome
     *  - Edge
     *
     * <p>Headless mode is enabled automatically when running in CI (env {@code CI=true})
     * or when the system property {@code headless=true} is set.</p>
     *
     * @return web driver instance
     */
    @Nonnull
    public static WebDriver getWebDriver() {
        try {
            FirefoxOptions options = new FirefoxOptions();
            if (HEADLESS) {
                options.addArguments("--headless");
                options.addArguments("--width=1920");
                options.addArguments("--height=1080");
            }
            return WebDriverManager.firefoxdriver().capabilities(options).create();
        } catch (WebDriverManagerException exception) {
            return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
            if (HEADLESS) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }
            return WebDriverManager.chromedriver().capabilities(options).create();
        } catch (WebDriverManagerException exception1) {
            return createEdgeDriver();
        }
    }

    private static WebDriver createEdgeDriver() {
        try {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
            if (HEADLESS) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }
            return WebDriverManager.edgedriver().capabilities(options).create();
        } catch (WebDriverManagerException exception1) {
            return createSafariDriver();
        }

    }

    private static WebDriver createSafariDriver() {
        SafariOptions options = new SafariOptions();
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("disableCorsRestrictions", "true");
        options.setCapability("bstack:options", browserstackOptions);

        return WebDriverManager.safaridriver().capabilities(options).create();
    }
}
