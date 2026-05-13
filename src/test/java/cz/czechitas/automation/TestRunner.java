package cz.czechitas.automation;

import cz.czechitas.automation.extension.ScreenshotOnFailExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import cz.czechitas.automation.assertion.AssertionFacade;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Base test runner class for low code automation on the {@code https://czechitas-app.kutac.cz/} page
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
class TestRunner {

    private final WebDriver webDriver;
    private final String baseUrl;

    protected final SeleniumActionFacade browser;
    protected final AssertionFacade asserter;

    @RegisterExtension
    final ScreenshotOnFailExtension screenshotExtension;

    public TestRunner() {
        this.webDriver = WebDriverProvider.getWebDriver();
        this.browser = new SeleniumActionFacade(webDriver);
        this.asserter = new AssertionFacade(webDriver);
        this.screenshotExtension = new ScreenshotOnFailExtension(webDriver);

        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test.properties", e);
        }

        // System property overrides file property
        String resolvedUrl = System.getProperty("app.url", props.getProperty("app.url"));
        if (resolvedUrl == null || resolvedUrl.isBlank()) {
            throw new IllegalStateException("app.url is not configured. Set it via the 'app.url' system property or in test.properties.");
        }
        this.baseUrl = resolvedUrl;
    }

    @BeforeEach
    void setUp() {
        webDriver.get(baseUrl);
    }

    @AfterEach
    void tearDown() {
        try {
            Thread.sleep(3000);
            webDriver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}