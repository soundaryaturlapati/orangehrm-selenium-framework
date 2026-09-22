package com.orangehrm.runners;

import com.orangehrm.utils.ConfigReader;
import org.testng.annotations.Test;

public class ConfigTest {

    @Test
    public void TestConfig() {
        System.out.println("Testing Config");
        System.out.println(ConfigReader.getProperty("browser"));
        System.out.println(ConfigReader.getProperty("url"));
    }
}
