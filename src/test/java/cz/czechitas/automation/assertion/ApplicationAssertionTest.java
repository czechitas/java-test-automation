package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinderInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

@ParametersAreNonnullByDefault
@ExtendWith(MockitoExtension.class)
class ApplicationAssertionTest {

    @Mock
    ElementFinderInterface elementFinder;

    private static WebElement mockElementWithText(String text) {
        WebElement el = mock(WebElement.class);
        when(el.getText()).thenReturn(text);
        return el;
    }

    // Re-implementation of production xpathLiteral for building expected xpath in tests
    private static String xpathLiteralForTest(String s) {
        if (!s.contains("'")) {
            return "'" + s + "'";
        }
        if (!s.contains("\"")) {
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

    @Test
    void checkColumnExists_singleColumn() {
        String column = "Name";
        String expectedXpath = "//table[@id='DataTables_Table_0']/thead/tr/th[normalize-space(.) = " + xpathLiteralForTest(column) + "]";
        doReturn(mockElementWithText(column)).when(elementFinder).findByXPath(expectedXpath);

        ApplicationAssertion assertion = new ApplicationAssertion(elementFinder);

        assertThatCode(() -> assertion.checkColumnExists(column)).doesNotThrowAnyException();
        verify(elementFinder).findByXPath(expectedXpath);
    }

    @Test
    void checkColumnExists_multipleColumns() {
        String col1 = "Name";
        String col2 = "Email";

        String xpath1 = "//table[@id='DataTables_Table_0']/thead/tr/th[normalize-space(.) = " + xpathLiteralForTest(col1) + "]";
        String xpath2 = "//table[@id='DataTables_Table_0']/thead/tr/th[normalize-space(.) = " + xpathLiteralForTest(col2) + "]";

        doReturn(mockElementWithText(col1)).when(elementFinder).findByXPath(xpath1);
        doReturn(mockElementWithText(col2)).when(elementFinder).findByXPath(xpath2);

        ApplicationAssertion assertion = new ApplicationAssertion(elementFinder);

        assertThatCode(() -> assertion.checkColumnExists(col1, col2)).doesNotThrowAnyException();
        verify(elementFinder).findByXPath(xpath1);
        verify(elementFinder).findByXPath(xpath2);
    }

    @Test
    void checkColumnExists_columnWithBothQuotes() {
        String col = "O'Hara \"Test\"";
        String expectedXpath = "//table[@id='DataTables_Table_0']/thead/tr/th[normalize-space(.) = " + xpathLiteralForTest(col) + "]";
        doReturn(mockElementWithText(col)).when(elementFinder).findByXPath(expectedXpath);

        ApplicationAssertion assertion = new ApplicationAssertion(elementFinder);

        assertThatCode(() -> assertion.checkColumnExists(col)).doesNotThrowAnyException();
        verify(elementFinder).findByXPath(expectedXpath);
    }
}
