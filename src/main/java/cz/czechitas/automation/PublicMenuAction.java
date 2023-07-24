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
        var agreeButton = elementFinder.findByXPath("//div[@id='navbarSupportedContent']//a[contains(text(), 'Kontakt')]");
        agreeButton.click();
    }

    void goToInstructionsAndFormsForTeacherSection() {
        clickForTeacherMenuItem();
        var menuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Pro učitelé')]//..//a[text()='Návody a formuláře']");
        menuItem.click();
    }

    void goToKindergartenAndSchoolSection() {
        clickForTeacherMenuItem();
        var orderMenuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[text()='Objednávka pro MŠ/ZŠ']");
        orderMenuItem.click();
    }

    void goToInstructionsAndFormsForParentSection() {
        clickForParentMenuItem();
        var formMenuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Pro rodiče')]//..//a[text()='Návody a formuláře']");
        formMenuItem.click();
    }

    void goToCreateApplicationSection() {
        clickForParentMenuItem();
        var createApplicationMenuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[text()='Vytvořit přihlášku']");
        createApplicationMenuItem.click();
    }

    void goToHomePage() {
        var homeMenuItem = elementFinder.findByXPath("//div[@id='navbarSupportedContent']//a[contains(text(), 'Domů')]");
        homeMenuItem.click();
    }

    void goToApplicationsSection() {
        var applicationsMenuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Přihlášky')]");
        applicationsMenuItem.click();
    }

    private void clickForTeacherMenuItem() {
        var forTeacherMenuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Pro učitelé')]");
        forTeacherMenuItem.click();
    }

    private void clickForParentMenuItem() {
        var forParentMenuItem = elementFinder.findByXPath("//*[@id='navbarSupportedContent']//a[contains(text(), 'Pro rodiče')]");
        forParentMenuItem.click();
    }
}
