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

    public final PublicMenuAction publicMenuAction;
    private final InternalMenuAction internalMenuAction;
    private final UserAction userAction;

    public SeleniumActionFacade(WebDriver driver) {
        var elementFinder = new ElementFinder(Objects.requireNonNull(driver));
        this.publicMenuAction = new PublicMenuAction(elementFinder);
        this.internalMenuAction = new InternalMenuAction(elementFinder);
        this.userAction = new UserAction(elementFinder);
    }

    void jdiDoSekceKontakt() {
        publicMenuAction.jdiDoSekceKontakt();
    }

    void jdiDoSekceNavodyAFormulareProUcitele() {
        publicMenuAction.jdiDoSekceNavodyAFormulareProUcitele();
    }

    void jdiDoSekceObjednavkaProMSZS() {
        publicMenuAction.jdiDoSekceObjednavkaProMSZS();
    }

    void jdiDoSekceNavodyAFormulareProRodice() {
        publicMenuAction.jdiDoSekceNavodyAFormulareProRodice();
    }

    void jdiDoSekceVytvorPrihlasku() {
        publicMenuAction.jdiDoSekceVytvorPrihlasku();
    }

    void jdiDoSekceDomu() {
        publicMenuAction.jdiDoSekceDomu();
    }

    void jdiDoSekceObjednavky() {
        internalMenuAction.jdiDoSekceObjednavky();
    }

    void jdiDoSekceTerminy() {
        internalMenuAction.jdiDoSekceTerminy();
    }

    void jdiDoSekcePrihlasky() {
        internalMenuAction.jdiDoSekcePrihlasky();
    }

    void jdiDoSekceKategorie() {
        internalMenuAction.jdiDoSekceKategorie();
    }

    void jdiDoSekceAktuality() {
        internalMenuAction.jdiDoSekceAktuality();
    }

    void jdiDoSekceExporty() {
        internalMenuAction.jdiDoSekceExporty();
    }

    void klikniNaTlacitkoPrihlasit() {
        userAction.klikniNaTlacitkoPrihlasit();
    }

    void vyplnEmail(String email) {
        userAction.vyplnEmail(Objects.requireNonNull(email));
    }

    void vyplnHeslo(String heslo) {
        userAction.vyplnHeslo(Objects.requireNonNull(heslo));
    }

    void provedPrihlaseni() {
        userAction.provedPrihlaseni();
    }

    void provedOdhlaseni() {
        userAction.provedOdhlaseni();
    }

    void cekejNekolikVterin(long vteriny) {
        try {
            Thread.sleep(vteriny * 1000);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
