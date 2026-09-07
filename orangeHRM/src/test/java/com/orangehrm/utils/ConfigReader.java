package com.orangehrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static{
        try{
            FileInputStream fis = new FileInputStream("orangeHRM/src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(fis);

        }
        catch (IOException e){
            throw new RuntimeException("Config file not found");

        }
    }
    public static String  getProperty(String key){
        return properties.getProperty(key);
    }

}
