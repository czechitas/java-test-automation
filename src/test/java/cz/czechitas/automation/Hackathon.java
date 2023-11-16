package cz.czechitas.automation;

import cz.czechitas.automation.assertion.HackathonAsserter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hackathon extends TestRunner {
    ElementFinder ef = new ElementFinder(webDriver);
    HackathonAsserter asserter = new HackathonAsserter(ef);


    @Test
    public void openCzechitas() {
        webDriver.get("https://www.czechitas.cz");
        browser.waitFor(5);
        ef.findByCssSelector(".ch2-allow-all-btn").click();
        ef.findByXPath("/html/body/div[2]/section/div/div/div[1]/a/div[2]").click();
        Assertions.assertEquals(webDriver.getCurrentUrl(), "https://www.czechitas.cz/digitalni-dovednosti");
        asserter.checkElementTextCss(".hp-h1", "DIGITÁLNÍ DOVEDNOSTI");
    }

    @Test
    public void realgeek() {
        webDriver.get("https://www.realgeek.cz/siryakari/4354-mikina-siryakari.html");
        ef.findByCssSelector(".cookiesplus-accept-label").click();
        //click XS
        ef.findByXPath("/html/body/main/div/div[2]/div/div/section[2]/div[1]/div[3]/div[2]/div/section/div/div/div[2]/div/div[3]/div/div[1]/label/span").click();
        //click + 3 times
        ef.findByXPath("/html/body/main/div/div[2]/div/div/section[2]/div[1]/div[3]/div[2]/div/section/div/div/div[2]/div/div[3]/div[1]/span[2]").click();
        ef.findByXPath("/html/body/main/div/div[2]/div/div/section[2]/div[1]/div[3]/div[2]/div/section/div/div/div[2]/div/div[3]/div[1]/span[2]").click();
        ef.findByXPath("/html/body/main/div/div[2]/div/div/section[2]/div[1]/div[3]/div[2]/div/section/div/div/div[2]/div/div[3]/div[1]/span[2]").click();

        //add to cart
        ef.findByXPath("/html/body/main/div/div[2]/div/div/section[2]/div[1]/div[3]/div[2]/div/section/div/div/div[2]/div/div[3]/div[2]/a").click();
        //confirm
        ef.findByXPath("/html/body/main/div/div[2]/div/div/section[2]/div[1]/div[3]/div[2]/div/section/div/div/div/div[2]/div[3]/button[2]").click();

        browser.waitFor(5);
        //Open cart
        webDriver.get("https://www.realgeek.cz/objednavka");

        browser.waitFor(5);
        asserter.checkElementTextCss(".cc-price--total", "4 396 Kč");


    }
}
