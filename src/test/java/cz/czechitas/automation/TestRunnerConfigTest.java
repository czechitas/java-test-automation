package cz.czechitas.automation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class TestRunnerConfigTest {

    private static final String APP_URL_PROPERTY = "app.url";
    private static final String EXPECTED_BASE_URL = "https://lecturers.datcj26.czechitas.online/";

    @AfterEach
    void clearSystemProperty() {
        System.clearProperty(APP_URL_PROPERTY);
    }

    @Test
    void propertiesFile_containsNewBaseUrl() throws IOException {
        Properties props = loadTestProperties();

        assertThat(props.getProperty(APP_URL_PROPERTY)).isEqualTo(EXPECTED_BASE_URL);
    }

    @Test
    void withNoSystemProperty_baseUrlComesFromPropertiesFile() throws IOException {
        System.clearProperty(APP_URL_PROPERTY);
        Properties props = loadTestProperties();

        String resolvedUrl = System.getProperty(APP_URL_PROPERTY, props.getProperty(APP_URL_PROPERTY));

        assertThat(resolvedUrl).isEqualTo(EXPECTED_BASE_URL);
    }

    @Test
    void systemProperty_overridesPropertiesFileUrl() throws IOException {
        String overrideUrl = "https://override.example.com/";
        System.setProperty(APP_URL_PROPERTY, overrideUrl);
        Properties props = loadTestProperties();

        String resolvedUrl = System.getProperty(APP_URL_PROPERTY, props.getProperty(APP_URL_PROPERTY));

        assertThat(resolvedUrl).isEqualTo(overrideUrl);
    }

    @Test
    void withNoSystemPropertyAndEmptyFile_baseUrlIsNull() {
        System.clearProperty(APP_URL_PROPERTY);
        Properties emptyProps = new Properties();

        String resolvedUrl = System.getProperty(APP_URL_PROPERTY, emptyProps.getProperty(APP_URL_PROPERTY));

        assertThat(resolvedUrl).isNull();
    }

    private Properties loadTestProperties() throws IOException {
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            if (in != null) {
                props.load(in);
            }
        }
        return props;
    }
}
