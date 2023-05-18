package cz.czechitas.automation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Example test class for functionality showcase
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class ExampleTest extends TestRunner {

    @Test
    void overKontaktniWwwAdresu() {
        prohlizec.jdiDoSekceKontakt();
        overeni.overAdresuWwwStranky("www.czechitas.cz");
    }

    @Test
    void overUspesnePrihlaseni() {
        prohlizec.klikniNaTlacitkoPrihlasit();
        prohlizec.vyplnEmail("da-app.admin@czechitas.cz");
        prohlizec.vyplnHeslo("Czechitas123");
        prohlizec.provedPrihlaseni();
        overeni.overPrihlaseniUzivatele();
    }

    // test s parametry, ukázka - zjisti, co vše je na tomto testu divné
    @ParameterizedTest()
    @ValueSource(strings = {"123456789", "ASDFBVC", "123"})
    void overPolickoIco(String icoCislo) {
        prohlizec.jdiDoSekceObjednavkaProMSZS();
        prohlizec.vyplnICO(icoCislo);
    }
}
