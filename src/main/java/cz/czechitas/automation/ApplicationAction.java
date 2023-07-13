package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Application selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class ApplicationAction {

    private final ElementFinder elementFinder;

    ApplicationAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void clickCreateNewApplicationButton() {
        var createApplicationButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[1]/a");
        createApplicationButton.click();
    }

    void selectProgrammingSection() {
        var programmingSectionButton = elementFinder.findByXPath("/html/body/div/div/div[1]/div[3]/div/div[2]/a");
        programmingSectionButton.click();
    }

    void clickCreateApplicationButton() {
        var createApplicationButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/div/div[2]/a");
        createApplicationButton.click();
    }

    void openFirstApplicationDetailsPage() {
        var openApplicationButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr/td[5]/div/a[1]");
        openApplicationButton.click();
    }

    void search(String textToSearch) {
        var searchInput = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[1]/div/div[2]/div/label/input");
        searchInput.sendKeys(textToSearch);
    }

    void clickEditFirstApplicationButton() {
        var firstApplicationEditButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[5]/div/a[2]");
        firstApplicationEditButton.click();
    }

    void clickViewFirstApplicationButton() {
        var firstApplicationDetailButton = elementFinder.findByXPath(
                "/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[5]/div/a[1]/i");
        firstApplicationDetailButton.click();
    }
}
