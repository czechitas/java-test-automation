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

    void jdiDoSekceObjednavky() {
        var ordersMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]/div/a[1]");
        ordersMenuItem.click();
    }

    void jdiDoSekceTerminy() {
        var datesMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]/div/a[2]");
        datesMenuItem.click();
    }

    void jdiDoSekcePrihlasky() {
        var applicationsMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]/div/a[3]");
        applicationsMenuItem.click();
    }

    void jdiDoSekceKategorie() {
        var categoriesMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]/div/a[4]");
        categoriesMenuItem.click();
    }

    void jdiDoSekceAktuality() {
        var newsMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]/div/a[5]");
        newsMenuItem.click();
    }

    void jdiDoSekceExporty() {
        var exportsMenuItem = elementFinder.findByXPath("//*[@id=\"adminNavbar\"]/div/a[6]");
        exportsMenuItem.click();
    }
}
