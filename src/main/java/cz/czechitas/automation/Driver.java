package cz.czechitas.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * WebDriver initializer
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
public final class Driver
{
    public static final String PATH = "driver/geckodriver";

    private final WebDriver webDriver;

    public Driver()
    {
        System.setProperty("webdriver.gecko.driver", PATH);
        this.webDriver = new FirefoxDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
    }

    @Nonnull
    public WebDriver getWebDriver()
    {
        return webDriver;
    }
}
