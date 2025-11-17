package cz.czechitas.automation;

import java.util.Objects;

final class UsersAction {

    private final ElementFinder elementFinder;

     UsersAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    /**
     * Click Vytvorit novou prihlasku on table view
     */
    void clickCreateNewUserButton() {
        var createUserButton = elementFinder.findByCssSelector("a.btn-info");
        createUserButton.click();
    }

    void search(String textToSearch) {
        var searchInput = elementFinder.findByXPath("//input[@type='search']");
        searchInput.clear();
        searchInput.sendKeys(textToSearch);
    }
}
