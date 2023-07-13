package cz.czechitas.automation.extension;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotOnFailExtension implements TestExecutionExceptionHandler {

    private final WebDriver driver;

    public ScreenshotOnFailExtension(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable cause) throws Throwable {

        if (driver != null) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss__"));
            try {
                String screenshotDir = "failedScreenshots/";
                FileUtils.copyFile(screenshotFile, new File(screenshotDir + formattedTime + context.getDisplayName() + ".png"));
            } catch (IOException e) {
                System.out.println("Could not save taken screenshot: " + e);
            }
        }

        throw cause;
    }
}
