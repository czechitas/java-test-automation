package cz.czechitas.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Selenium actions facade for working with browser
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@SuppressWarnings("unused")
final class SeleniumActionFacade {

    private final ElementFinder elementFinder;
    public final PublicMenuAction publicMenuAction;
    private final InternalMenuAction internalMenuAction;
    private final UserAction userAction;

    public SeleniumActionFacade(@Nonnull WebDriver driver) {
        this.elementFinder = new ElementFinder(Objects.requireNonNull(driver));
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

    void overAdresuWwwStranky(String wwwAdresa) {
        var url = findByXPath("/html/body/div/div/div/div/div/div/div/div[1]/p[2]/a");
        assertThat(url.getText()).isEqualTo(wwwAdresa);
    }

    void klikniNaTlacitkoPrihlasit() {
        userAction.klikniNaTlacitkoPrihlasit();
    }

    void vyplnEmail(String email) {
        userAction.vyplnEmail(email);
    }

    void vyplnHeslo(String heslo) {
        userAction.vyplnHeslo(heslo);
    }

    void provedPrihlaseni() {
        userAction.provedPrihlaseni();
    }

    void provedOdhlaseni() {
        userAction.provedOdhlaseni();
    }

    void overPrihlaseniUzivatele() {
        userAction.overPrihlaseniUzivatele();
    }

    @Nonnull
    private WebElement findByXPath(String xpathExpression) {
        return elementFinder.findByXPath(xpathExpression);
    }
}
