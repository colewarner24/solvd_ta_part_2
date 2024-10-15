package booking.util;

import booking.exception.DAOConfigurationException;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class DAOProperties {
    private static final Properties PROPERTIES = new Properties();
    private static final String PROPERTIES_FILE = "dao.properties";
    String propertyKeyName;

    static {
        try (InputStream input = DAOProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input != null) {
                PROPERTIES.load(input);
            } else {
                throw new DAOConfigurationException("Properties file not found: " + PROPERTIES_FILE);
            }
        } catch (Exception e) {
            throw new DAOConfigurationException("Failed to load properties file: " + PROPERTIES_FILE);
        }
    }

    public DAOProperties(String keyName) {
        this.propertyKeyName = keyName;
    }

    public String getProperty(String key, boolean required) {
        String fullKey = propertyKeyName + "." + key;
        String property = Optional.ofNullable(PROPERTIES.getProperty(fullKey))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .orElse(null);

        if (required && property == null) {
            throw new DAOConfigurationException(String.format("Required property is '%s' is missing in properties file '%s'.", fullKey, PROPERTIES_FILE));
        }
        return property;
    }

}
