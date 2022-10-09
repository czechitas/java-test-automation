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
    private final PublicMenuAction publicMenuAction;
    private final InternalMenuAction internalMenuAction;

    public SeleniumActionFacade(@Nonnull WebDriver driver) {
        this.elementFinder = new ElementFinder(Objects.requireNonNull(driver));
        this.publicMenuAction = new PublicMenuAction(elementFinder);
        this.internalMenuAction = new InternalMenuAction(elementFinder);
    }

    void jdiDoSekceKontakt() {
        var agreeButton = findByXPath("/html/body/div/header/nav/div/div[1]/a[2]");
        agreeButton.click();
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
        var loginButton = findByXPath("/html/body/div/header/nav/div/div[2]/a");
        loginButton.click();
    }

    void vyplnEmail(String email) {
        var emailInputBox = findByXPath("//*[@id=\"email\"]");
        emailInputBox.sendKeys(email);
    }

    void vyplnHeslo(String heslo) {
        var passwordInputBox = findByXPath("//*[@id=\"password\"]");
        passwordInputBox.sendKeys(heslo);
    }

    void provedPrihlaseni() {
        var loginButton = findByXPath("/html/body/div/div/div/div/div/div/form/div[3]/div/button");
        loginButton.click();
    }

    void overPrihlaseniUzivatele() {
        var loggedInText = findByXPath("/html/body/div/header/nav[1]/div/div[2]/div/span");
        assertThat(loggedInText.getText()).isEqualTo("Přihlášen");
    }

    @Nonnull
    private WebElement findByXPath(String xpathExpression) {
        return elementFinder.findByXPath(xpathExpression);
    }
}
