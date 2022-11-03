package cz.czechitas.automation;

import org.openqa.selenium.WebDriver;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Selenium actions facade for working with browser
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
final class SeleniumActionFacade {

    final PublicMenuAction horniMenu;
    final InternalMenuAction interniMenu;
    final LoginAction prihlasovani;
    final OrderAction sekceObjednavky;
    final ApplicationAction sekcePrihlasky;
    final NewApplication novaPrihlaska;

    public SeleniumActionFacade(WebDriver driver) {
        var elementFinder = new ElementFinder(Objects.requireNonNull(driver));
        this.horniMenu = new PublicMenuAction(elementFinder);
        this.interniMenu = new InternalMenuAction(elementFinder);
        this.prihlasovani = new LoginAction(elementFinder);
        this.sekceObjednavky = new OrderAction(elementFinder);
        this.sekcePrihlasky = new ApplicationAction(elementFinder);
        this.novaPrihlaska = new NewApplication(elementFinder);
    }

    void cekejNekolikVterin(long vteriny) {
        try {
            Thread.sleep(vteriny * 1000);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
