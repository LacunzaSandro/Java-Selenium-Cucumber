package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader propertiesReader;
    private static Properties prop = new Properties();
    private static final String FILE_NAME = "global.properties";

    private PropertiesReader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + FILE_NAME);
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void loadProperties() {
        if (propertiesReader==null) {
            propertiesReader = new PropertiesReader();
        }
    }
    public static String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
