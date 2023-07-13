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
    final LoginAction loginSection;
    final OrderAction orderSection;
    final ApplicationAction applicationSection;
    final ApplicationDetail applicationDetailsSection;
    final ProfileAction profileSection;

    public SeleniumActionFacade(WebDriver driver) {
        var elementFinder = new ElementFinder(Objects.requireNonNull(driver));
        this.headerMenu = new PublicMenuAction(elementFinder);
        this.internalMenu = new InternalMenuAction(elementFinder);
        this.loginSection = new LoginAction(elementFinder);
        this.orderSection = new OrderAction(elementFinder);
        this.applicationSection = new ApplicationAction(elementFinder);
        this.applicationDetailsSection = new ApplicationDetail(elementFinder);
        this.profileSection = new ProfileAction(elementFinder);
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
