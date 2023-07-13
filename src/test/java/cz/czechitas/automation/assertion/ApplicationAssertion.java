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
        var column = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[2]/div[2]/div/table/thead/tr");
        assertThat(column.getText()).contains(columnName);
    }

    public void checkUrl(String url) {
        var urlElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/div/div[1]/p[2]/a");
        assertThat(urlElement.getText()).isEqualTo(url);
    }

    public void checkApplicationsTableIsEmpty() {
        var applicationsCountElement = elementFinder.findByXPath("//*[@id=\"DataTables_Table_0_info\"]");
        assertThat(applicationsCountElement.getText()).contains("Žádné záznamy nenalezeny");
    }

    public void checkNumberOfApplications(int applicationsNumber) {
        var applicationsCountElement = elementFinder.findByXPath("//*[@id=\"DataTables_Table_0_info\"]");
        assertThat(applicationsCountElement.getText()).contains("Zobrazeno " + applicationsNumber + " až " + applicationsNumber +
                " záznamů z " + applicationsNumber);
    }
}
