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

    /**
     * Click Vytvorit novou prihlasku on table view
     */
    void clickCreateNewApplicationButton() {
        var createApplicationButton = elementFinder.findByCssSelector(".card-header a");
        createApplicationButton.click();
    }

    void selectProgrammingSection() {
        var programmingSectionButton = elementFinder.findByXPath("//*[contains(text(), 'Programování')]//ancestor::*[@class='card']//a");
        programmingSectionButton.click();
    }

    /**
     * Click Vytvorit prihlasku for Python course
     */
    void clickCreatePythonApplicationButton() {
        //TODO: modify css selector to reflect python course instead of first course (method parameter?)
        var createApplicationButton = elementFinder.findByCssSelector(".card-body a");
        createApplicationButton.click();
    }

    void openFirstApplicationDetailsPage() {
        var openApplicationButton = elementFinder.findByXPath(
                "//tr[1]//a[@title='Zobrazit']");
        openApplicationButton.click();
    }

    void search(String textToSearch) {
        var searchInput = elementFinder.findByXPath("//input[@type='search']");
        searchInput.clear();
        searchInput.sendKeys(textToSearch);
    }

    void clickEditFirstApplicationButton() {
        var firstApplicationEditButton = elementFinder.findByXPath(
                "//tr[1]//a[@title='Upravit']");
        firstApplicationEditButton.click();
    }

    void clickCancelFirstApplicationButton()  {
        var firstApplicationCancelButton = elementFinder.findByCssSelector(
                "tr.odd:nth-child(1) > td:nth-child(5) > div:nth-child(1) > a:nth-child(3)");
        firstApplicationCancelButton.click();
    }

    void selectIllnessOption() {
        var illnessButton = elementFinder.findByCssSelector("span.custom-control:nth-child(1) > label:nth-child(2)");
        illnessButton.click();
    }

    void selectOtherReasonOption() {
        var otherReasonOption = elementFinder.findByCssSelector("span.custom-control:nth-child(2) > label:nth-child(2)");
        otherReasonOption.click();
    }

    void insertReason(String reason) {
        var reasonInput = elementFinder.findByCssSelector("#logged_out_reason");
        reasonInput.sendKeys(reason);
    }

    void clickCancelApplicationButton() {
        var cancelApplicationButton = elementFinder.findByCssSelector(".btn");
        cancelApplicationButton.click();
    }
}
