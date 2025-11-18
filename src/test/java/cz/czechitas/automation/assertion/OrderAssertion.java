package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Order specific assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class OrderAssertion {
    private final ElementFinder elementFinder;

    OrderAssertion(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkOrdersTableIsEmpty() {
        var ordersCountElement = elementFinder.findByCssSelector("#DataTables_Table_0_info");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ordersCountElement.getText();
        assertThat(ordersCountElement.getText()).contains("Žádné záznamy nenalezeny");
    }

    public void checkNumberOfOrders(int orderCount) {
        var ordersCountElement = elementFinder.findByCssSelector("#DataTables_Table_0_info");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ordersCountElement.getText();
        assertThat(ordersCountElement.getText()).contains("Zobrazeno " + orderCount + " až " + orderCount +
                " záznamů z " + orderCount);
    }
    public void checkOrderIsCreated () {
        var message = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/h3");
        assertThat(message.getText()).contains("Děkujeme za objednávku");
    }
}
