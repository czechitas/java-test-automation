package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Public order selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class OrderAction {

    private final ElementFinder elementFinder;

    OrderAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void selectSuburbanCampOption() {
        var suburbanCampButton = elementFinder.findByXPath("//*[@id='nav-home-tab']");
        suburbanCampButton.click();
    }

    void selectSchoolInNatureOption() {
        var schoolInNatureButton = elementFinder.findByXPath("//*[@id='nav-profile-tab']");
        schoolInNatureButton.click();
    }

    void insertICO(String ico) {
        Objects.requireNonNull(ico);

        var icoInputBox = elementFinder.findByXPath("//*[@id='ico']");
        icoInputBox.sendKeys(ico);
        var fullAddressElement = elementFinder.findByXPath("//*[@id='address']");
        fullAddressElement.click();
    }

    void insertChildrenCount(int childrenCount) {
        var natureStudentsInput = elementFinder.findByXPath("//*[@id='nature-students']");
        natureStudentsInput.sendKeys(String.valueOf(childrenCount));
    }

    void clickAddButton() {
        var addButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[1]/a");
        addButton.click();
    }

    void search(String textToSearch) {
        var searchInput = elementFinder.findByXPath("//input[@type='search']");
        searchInput.clear();
        searchInput.sendKeys(textToSearch);
    }
    void deleteOrder() {
        var deleteButton = elementFinder.findByCssSelector(".odd > td:nth-child(6) > div:nth-child(1) > a:nth-child(3)");
        deleteButton.click();
        var confirmButton = elementFinder.findByXPath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div/table/tbody/tr/td[6]/div[2]/div/div/div/div[2]/form/button");
        confirmButton.click();
    }
}
