# Low-code Test Automation framework

Framework pro výuku základů low-code automatizace nad projekty digitální akademie testování Czechitas.

Ve výchozím stavu by po spuštění měl framework začít používat webový prohlížeč dle Vámi nainstalovaných 
bez nutnosti stahovaní dodatečných ovladačů. Předpokladem je, že uživatel má nainstalován jeden z webových prohlížečů
Firefox, Chrome nebo Edge.

Ukázkový test ve třídě ExampleTest otevře webový prohlížeč a ověří, že v testovací aplikaci je v sekci kontakty 
přítomna adresa www.czechitas.cz.

# Hierarchie elementů

Práce s frameworkem je členěna dle elementů testovací aplikace následovně

Prohlizec
    |   horniMenu (Akce pro navigaci v horním menu)
    |   interniMenu (Akce pro navigaci v interním administrátorském menu)
    |   prihlasovani (Akce pro přihlašování a odhlašování)
    |   sekceObjednavky (Akce pro sekci objednávek)
    |   sekcePrihlasky (Akce pro sekci přihlášek)
    |   detailPrihlasky (Akce pro vytváření a editaci přihlášek)

Overeni
    |   sekcePrihlasky (Assertace v sekci přihlášek)
    |   detailPrihlasky (Assertace na detailu přihlášky)