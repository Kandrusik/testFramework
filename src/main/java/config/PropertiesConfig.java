package config;

import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
    private static final String PATH_TO_CONFIG_PROPERTIES = "src/test/resources/conf.properties";
    protected static FileInputStream fileInputStream;
    protected static Properties properties;
    protected static Logger LOGGER = Logger.getLogger(PropertiesConfig.class);

    static {
        LOGGER.info("Properties getting: Path = '" + PATH_TO_CONFIG_PROPERTIES + "'");
        try {
            fileInputStream = new FileInputStream(PATH_TO_CONFIG_PROPERTIES);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
