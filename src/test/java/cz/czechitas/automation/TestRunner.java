package cz.czechitas.automation;

import cz.czechitas.automation.extension.ScreenshotOnFailExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import cz.czechitas.automation.assertion.AssertionFacade;

/**
 * Base test runner class for low code automation on the {@code https://czechitas-app.kutac.cz/} page
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
class TestRunner {

    private final WebDriver webDriver;

    protected final SeleniumActionFacade prohlizec;
    protected final AssertionFacade overeni;

    @RegisterExtension
    final ScreenshotOnFailExtension screenshotExtension;

    public TestRunner() {
        this.webDriver = WebDriverProvider.getWebDriver();
        this.prohlizec = new SeleniumActionFacade(webDriver);
        this.overeni = new AssertionFacade(webDriver);
        this.screenshotExtension = new ScreenshotOnFailExtension(webDriver);
    }

    @BeforeEach
    void setUp() {
        webDriver.get("https://team8-2022brno.herokuapp.com/");
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
