package cz.czechitas.automation.extension;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotOnFailExtension implements TestExecutionExceptionHandler {

    private final WebDriver driver;

    public ScreenshotOnFailExtension(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable cause) throws Throwable {

        if (driver != null) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String SCREENSHOT_DIRECTORY = "failedScreenshots/";
                FileUtils.copyFile(screenshotFile, new File(SCREENSHOT_DIRECTORY + context.getDisplayName() + ".png"));
            } catch (IOException e) {
                System.out.println("Could not save taken screenshot: " + e);
            }
        }

        throw cause; // Re-throw the exception to allow JUnit to handle it
    }
}
