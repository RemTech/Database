package com.dbconfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {

    private static String value;

    public static String getProperties(String key) {

        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\DatabaseConfig.properties");
            properties.load(fileInputStream);
            value=properties.getProperty(key);
        } catch (IOException ex) {
            ex.getCause();
        }
        return value;
    }
}
