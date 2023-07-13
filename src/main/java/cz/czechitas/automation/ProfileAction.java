package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Profile specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class ProfileAction {

    private final ElementFinder elementFinder;

    ProfileAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void goToProfilePage() {
        var loggedInUserElement = elementFinder.findByXPath("/html/body/div/header/nav/div/div[2]/div/a/strong");
        loggedInUserElement.click();
        var profileButton = elementFinder.findByXPath("/html/body/div/header/nav/div/div[2]/div/div/a[1]");
        profileButton.click();
    }

    void insertPassword(String password) {
        var passwordInput = elementFinder.findByXPath("//*[@id=\"password\"]");
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    void insertPasswordVerification(String password) {
        var passwordControlInput = elementFinder.findByXPath("//*[@id=\"password-confirm\"]");
        passwordControlInput.sendKeys(password);
    }

    void clickChangeButton() {
        var changeButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[2]/form/div[4]/div/button");
        changeButton.click();
    }
}
