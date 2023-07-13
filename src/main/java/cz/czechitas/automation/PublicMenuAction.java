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

    void goToContactsSection() {
        var agreeButton = elementFinder.findByXPath("/html/body/div/header/nav/div/div[1]/a[2]");
        agreeButton.click();
    }

    void goToInstructionsAndFormsForTeacherSection() {
        clickForTeacherMenuItem();
        var menuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[2]/div/a[1]");
        menuItem.click();
    }

    void goToKindergartenAndSchoolSection() {
        clickForTeacherMenuItem();
        var orderMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[2]/div/a[2]");
        orderMenuItem.click();
    }

    void goToInstructionsAndFormsForParentSection() {
        clickForParentMenuItem();
        var formMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[1]/div/a[1]");
        formMenuItem.click();
    }

    void goToCreateApplicationSection() {
        clickForParentMenuItem();
        var createApplicationMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[1]/div/a[2]");
        createApplicationMenuItem.click();
    }

    void goToHomePage() {
        var homeMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/a[1]");
        homeMenuItem.click();
    }

    void goToApplicationsSection() {
        var applicationsMenuItem = elementFinder.findByXPath("/html/body/div/header/nav/div/div[1]/a[2]");
        applicationsMenuItem.click();
    }

    private void clickForTeacherMenuItem() {
        var forTeacherMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[2]/a");
        forTeacherMenuItem.click();
    }

    private void clickForParentMenuItem() {
        var forParentMenuItem = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[1]/div[1]/a");
        forParentMenuItem.click();
    }
}
