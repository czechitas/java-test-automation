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
public final class UsersAssertation {

    private final ElementFinder elementFinder;

    UsersAssertation(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkColumnExists(String columnName) {
        var column = elementFinder.findByXPath("//table[@id='DataTables_Table_0']/thead/tr");
        assertThat(column.getText()).contains(columnName);
    }
    public void checkParentRole() {
        var lastNameElement = elementFinder.findByCssSelector("td:nth-child(3)");
        assertThat(lastNameElement.getText()).isEqualTo("Rodič");
    }
}
