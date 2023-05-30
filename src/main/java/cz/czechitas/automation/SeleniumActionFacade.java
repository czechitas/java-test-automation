package cz.czechitas.automation;

import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;
import java.util.Random;

/**
 * Selenium actions facade for working with browser
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
final class SeleniumActionFacade {

    private final Random random = new Random();

    final PublicMenuAction horniMenu;
    final InternalMenuAction interniMenu;
    final LoginAction prihlasovani;
    final OrderAction sekceObjednavky;
    final ApplicationAction sekcePrihlasky;
    final ApplicationDetail detailPrihlasky;
    final ProfileAction profil;

    public SeleniumActionFacade(WebDriver driver) {
        var elementFinder = new ElementFinder(Objects.requireNonNull(driver));
        this.horniMenu = new PublicMenuAction(elementFinder);
        this.interniMenu = new InternalMenuAction(elementFinder);
        this.prihlasovani = new LoginAction(elementFinder);
        this.sekceObjednavky = new OrderAction(elementFinder);
        this.sekcePrihlasky = new ApplicationAction(elementFinder);
        this.detailPrihlasky = new ApplicationDetail(elementFinder);
        this.profil = new ProfileAction(elementFinder);
    }

    void cekejNekolikVterin(long vteriny) {
        try {
            Thread.sleep(vteriny * 1000);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    @Nonnull
    String vygenerujNahodnePrijmeni(int delkaPrijmeni) {
        var leftLimit = 97;
        var rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(delkaPrijmeni)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
