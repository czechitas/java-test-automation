package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Public menu selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class PublicMenuAction {

    private final ElementFinder elementFinder;

    PublicMenuAction(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void jdiDoSekceKontakt() {
        var agreeButton = elementFinder.findByXPath("/html/body/div/header/nav/div/div[1]/a[2]");
        agreeButton.click();
    }

    void jdiDoSekceNavodyAFormulareProUcitele() {
        clickOnForTeacherMenuItem();
        var menuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[2]/div/a[1]");
        menuItem.click();
    }

    void jdiDoSekceObjednavkaProMSZS() {
        clickOnForTeacherMenuItem();
        var orderMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[2]/div/a[2]");
        orderMenuItem.click();
    }

    void jdiDoSekceNavodyAFormulareProRodice() {
        clickOnForParentMenuItem();
        var formMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[1]/div/a[1]");
        formMenuItem.click();
    }

    void jdiDoSekceVytvorPrihlasku() {
        clickOnForParentMenuItem();
        var createApplicationMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[1]/div/a[2]");
        createApplicationMenuItem.click();
    }

    void jdiDoSekceDomu() {
        var homeMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/a[1]");
        homeMenuItem.click();
    }

    void jdiDoSekcePrihlasky() {
        var applicationsMenuItem = elementFinder.findByXPath("/html/body/div/header/nav/div/div[1]/a[2]");
        applicationsMenuItem.click();
    }

    private void clickOnForTeacherMenuItem() {
        var forTeacherMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[2]/a");
        forTeacherMenuItem.click();
    }

    private void clickOnForParentMenuItem() {
        var forParentMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[1]/a");
        forParentMenuItem.click();
    }
}
