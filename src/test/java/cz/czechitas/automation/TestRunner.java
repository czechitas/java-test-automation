package cz.czechitas.automation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

/**
 * Base test runner class for low code automation on the {@code https://czechitas-app.kutac.cz/} page
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
class TestRunner {

    private final WebDriver webDriver;

    protected SeleniumActionFacade firefox;

    public TestRunner() {
        var driver = new Driver();
        this.webDriver = driver.getWebDriver();
        this.firefox = new SeleniumActionFacade(webDriver);
    }

    @BeforeEach
    void setUp() {
        webDriver.get("https://czechitas-app.kutac.cz/");
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
