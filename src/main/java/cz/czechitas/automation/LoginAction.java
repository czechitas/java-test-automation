package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Login/logout specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class LoginAction {

    private final ElementFinder elementFinder;

    LoginAction(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void clickLoginMenuLink() {
        var loginButton = elementFinder.findByXPath("/html/body/div/header/nav/div/div[2]/a");
        loginButton.click();
    }

    void insertEmail(String email) {
        Objects.requireNonNull(email);

        var emailInputBox = elementFinder.findByXPath("//*[@id='email']");
        emailInputBox.sendKeys(email);
    }

    void insertPassword(String password) {
        Objects.requireNonNull(password);

        var passwordInputBox = elementFinder.findByXPath("//*[@id='password']");
        passwordInputBox.sendKeys(password);
    }

    void clickLoginButton() {
        var loginButton = elementFinder.findByXPath("//button[@type='submit']");
        loginButton.click();
    }

    void logout() {
        var signedInUserElement = elementFinder.findByXPath("//*[@id='navbarSupportedContent']/div[2]/div/a");
        signedInUserElement.click();
        var logoutButton = elementFinder.findByXPath("//*[@id='logout-link']");
        logoutButton.click();
    }
}
