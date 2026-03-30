package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinderInterface;

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

    private final ElementFinderInterface elementFinder;

    ApplicationAssertion(ElementFinderInterface elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkColumnExists(String... columnNames) {
        Objects.requireNonNull(columnNames);
        for (String columnName : columnNames) {
            Objects.requireNonNull(columnName);
            String xpath = "//table[@id='DataTables_Table_0']/thead/tr/th[normalize-space(.) = " + xpathLiteral(columnName) + "]";
            var column = elementFinder.findByXPath(xpath);
            assertThat(column.getText()).contains(columnName);
        }
    }

    private static String xpathLiteral(String s) {
        if (!s.contains("'")) {
            return "'" + s + "'";
        }
        if (!s.contains("\"" ) ) {
            return "\"" + s + "\"";
        }
        String[] parts = s.split("'");
        StringBuilder sb = new StringBuilder("concat(");
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                sb.append(", \"'\", ");
            }
            sb.append("'").append(parts[i]).append("'");
        }
        sb.append(")");
        return sb.toString();
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
}
