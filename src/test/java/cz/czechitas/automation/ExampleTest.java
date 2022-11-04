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
    void contactsPageUrlTest() {
        browser.headerMenu.goToContactsSection();
        asserter.checkPageUrl("www.czechitas.cz");
    }

    @Test
    void navigationTaskOne() {
        prohlizec.horniMenu.jdiDoSekceObjednavkaProMSZS();
        prohlizec.sekceObjednavky.vyplnICO("22834958");
        prohlizec.sekceObjednavky.vyberMoznostSkolaVPrirode();
        prohlizec.sekceObjednavky.vyplnPocetDeti(5);
    }

    @Test
    void assertionTaskOne() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("mistr@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Mtester123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        overeni.sekcePrihlasky.overExistenciSloupce("Jméno");
        overeni.sekcePrihlasky.overExistenciSloupce("Kategorie");
    }

    @Test
    void complexTaskOne() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("mistr@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Mtester123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        prohlizec.sekcePrihlasky.klikniNaVytvoreniNovePrihlasky();
        prohlizec.sekcePrihlasky.vyberObdobiProgramovani();
        prohlizec.sekcePrihlasky.klikniNaVytvoritPrihlasku();
        prohlizec.detailPrihlasky.vyberTermin("21.11. - 30.11.2022");
        prohlizec.detailPrihlasky.vyplnKrestniJmenoZaka("Pan");
        prohlizec.detailPrihlasky.vyplnPrijmeniZaka("Tester001");
        prohlizec.detailPrihlasky.vyplnDatumNarozeni("29.01.2000");
        prohlizec.detailPrihlasky.klikniNaSouhlasSPodminkami();
        prohlizec.detailPrihlasky.vyplnPoznamku("Moje super poznamka");
        prohlizec.detailPrihlasky.zvolZpusobUhradyHotove();
        prohlizec.detailPrihlasky.klikniNaVytvoritPrihlasku();
        overeni.detailPrihlasky.overZpusobUhradyPrihlasky("Hotově");
        overeni.detailPrihlasky.overKrestniJmeno("Pan");
        overeni.detailPrihlasky.overPrijmeni("Tester001");
        overeni.detailPrihlasky.overDatumNarozeni("29.01.2000");
        overeni.detailPrihlasky.overPoznamku("Moje super poznamka");
    }

    @Test
    void complexTaskThree() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("mistr@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Mtester123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        prohlizec.sekcePrihlasky.vyhledej("tester001");
        prohlizec.sekcePrihlasky.klikniNaUpravitUPrvniPrihlasky();
        prohlizec.detailPrihlasky.zvolZpusobUhradyBankovnimPrevodem();
        prohlizec.detailPrihlasky.klikniNaUpravitPrihlasku();
        prohlizec.sekcePrihlasky.klikniNaDetailUPrvniPrihlasky();
        overeni.detailPrihlasky.overZpusobUhradyPrihlasky("Bankovní převod");
        overeni.detailPrihlasky.overZbyvajiciCastkuKUhrazeni("1 500 Kč");
        overeni.detailPrihlasky.overZpravaProPrijemceObsahujePrijmeniZaka("Tester001");
    }

    @Test
    void complexTaskSix() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("mistr@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Mtester123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        prohlizec.sekcePrihlasky.klikniNaVytvoreniNovePrihlasky();
        prohlizec.sekcePrihlasky.vyberObdobiProgramovani();
        prohlizec.sekcePrihlasky.klikniNaVytvoritPrihlasku();
        prohlizec.detailPrihlasky.vyberTermin("123");
        prohlizec.detailPrihlasky.vyplnKrestniJmenoZaka("Pan");
        var generated = prohlizec.vygenerujNahodnePrijmeni(15);
        prohlizec.detailPrihlasky.vyplnPrijmeniZaka(generated);
        prohlizec.detailPrihlasky.vyplnDatumNarozeni("11.12.2000");
        prohlizec.detailPrihlasky.zvolZpusobUhradyHotove();
        prohlizec.detailPrihlasky.klikniNaSouhlasSPodminkami();
        prohlizec.detailPrihlasky.klikniNaVytvoritPrihlasku();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        prohlizec.sekcePrihlasky.vyhledej(generated);
        overeni.sekcePrihlasky.overZeVTabulcePrihlasekJePraveZobrazenych(1);
        prohlizec.prihlasovani.provedOdhlaseni();
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("ja@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Jtester123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        prohlizec.sekcePrihlasky.vyhledej(generated);
        overeni.sekcePrihlasky.overZeVTabulcePrihlasekNeniZadnaZobrazena();
    }

    @Test
    void complexTaskSeven() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("mistr@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Mtester123");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.profil.otevriProfil();
        prohlizec.profil.vyplnHeslo("Aaabbb123");
        prohlizec.profil.vyplnKontroluHesla("Aaabbb123");
        prohlizec.profil.klikniNaZmenit();
        prohlizec.cekejNekolikVterin(10);
        prohlizec.prihlasovani.provedOdhlaseni();
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("mistr@tester.cz");
        prohlizec.prihlasovani.vyplnHeslo("Aaabbb123");
        prohlizec.prihlasovani.provedPrihlaseni();
        overeni.overPrihlaseniUzivatele();
        prohlizec.profil.otevriProfil();
        prohlizec.profil.vyplnHeslo("Mtester123");
        prohlizec.profil.vyplnKontroluHesla("Mtester123");
        prohlizec.profil.klikniNaZmenit();
    }
}
