package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class HackathonAsserter {
    private final ElementFinder elementFinder;

    public HackathonAsserter(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    public void checkElementTextCss(String cssSelector, String expectedValue) {
        WebElement element = elementFinder.findByCssSelector(cssSelector);
        assertThat(element.getText().trim()).isEqualTo(expectedValue);
    }

    public void checkListElementTextCss(String cssSelector, int position, String expectedValue) {
        List<WebElement> elements = elementFinder.findListByCssSelector(cssSelector);
        assertThat(elements.get(position).getText().trim()).isEqualTo(expectedValue);
    }

    public void checkElementTextXPath(String xPath, String expectedValue) {
        WebElement element = elementFinder.findByXPath(xPath);
        assertThat(element.getText()).isEqualTo(expectedValue);
    }

    public void checkListElementTextXPath(String xPath, int position, String expectedValue) {
        List<WebElement> elements = elementFinder.findListByXPath(xPath);
        assertThat(elements.get(position).getText()).isEqualTo(expectedValue);
    }
}
