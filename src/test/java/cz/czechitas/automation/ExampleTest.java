package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

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
        prohlizec.vyplnEmail("admin@czechitas-app.loc");
        prohlizec.vyplnHeslo("Czechitas123");
        prohlizec.provedPrihlaseni();
        overeni.overPrihlaseniUzivatele();
    }
}
