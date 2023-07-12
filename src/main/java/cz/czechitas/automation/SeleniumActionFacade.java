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

    final PublicMenuAction headerMenu;
    final InternalMenuAction internalMenu;
    final LoginAction loginAction;
    final OrderAction orderAction;
    final ApplicationAction applicationAction;
    final ApplicationDetail applicationDetail;
    final ProfileAction profileAction;

    public SeleniumActionFacade(WebDriver driver) {
        var elementFinder = new ElementFinder(Objects.requireNonNull(driver));
        this.headerMenu = new PublicMenuAction(elementFinder);
        this.internalMenu = new InternalMenuAction(elementFinder);
        this.loginAction = new LoginAction(elementFinder);
        this.orderAction = new OrderAction(elementFinder);
        this.applicationAction = new ApplicationAction(elementFinder);
        this.applicationDetail = new ApplicationDetail(elementFinder);
        this.profileAction = new ProfileAction(elementFinder);
    }

    void waitFor(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    @Nonnull
    String generateRandomName(int nameLength) {
        var leftLimit = 97;
        var rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(nameLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
