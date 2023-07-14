package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Internal menu selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class InternalMenuAction {

    private final ElementFinder elementFinder;

    InternalMenuAction(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void goToOrdersSection() {
        var ordersMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]//a[contains(text(), 'Objednávky')]");
        ordersMenuItem.click();
    }

    void goToTermsSection() {
        var datesMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]//a[contains(text(), 'Termíny')]");
        datesMenuItem.click();
    }

    void goToApplicationsSection() {
        var applicationsMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]//a[contains(text(), 'Přihlášky')]");
        applicationsMenuItem.click();
    }

    void goToCategoriesSection() {
        var categoriesMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]//a[contains(text(), 'Kategorie')]");
        categoriesMenuItem.click();
    }

    void goToNewsSection() {
        var newsMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]//a[contains(text(), 'Aktuality')]");
        newsMenuItem.click();
    }

    void goToExportsSection() {
        var exportsMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]//a[contains(text(), 'Exporty')]");
        exportsMenuItem.click();
    }
}
