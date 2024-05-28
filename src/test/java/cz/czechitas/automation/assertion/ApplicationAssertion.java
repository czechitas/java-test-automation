package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Application specific assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class ApplicationAssertion {

    private final ElementFinder elementFinder;

    ApplicationAssertion(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkColumnExists(String columnName) {
        var column = elementFinder.findByXPath("//table[@id='DataTables_Table_0']/thead/tr");
        assertThat(column.getText()).contains(columnName);
    }

    public void checkApplicationsTableIsEmpty() {
        var applicationsCountElement = elementFinder.findByXPath("//*[@id='DataTables_Table_0_info']");
        assertThat(applicationsCountElement.getText()).contains("Žádné záznamy nenalezeny");
    }

    public void checkNumberOfApplications(int applicationsNumber) {
        var applicationsCountElement = elementFinder.findByXPath("//*[@id='DataTables_Table_0_info']");
        assertThat(applicationsCountElement.getText()).contains("Zobrazeno " + applicationsNumber + " až " + applicationsNumber +
                " záznamů z " + applicationsNumber);
    }

    public void checkIsLoggedIn() {
        var loggedInText = elementFinder.findByCssSelector(".navbar-right span");
        assertThat(loggedInText.getText()).isEqualTo("Přihlášen");
    }
}
