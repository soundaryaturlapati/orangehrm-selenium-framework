package com.orangehrm.hooks;

import com.orangehrm.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks  {

    @Before
    public void setUp() {
        System.out.println("Before Hooks");
        DriverFactory.getDriver();
    }

//    @After
//    public void tearDown() {
//        System.out.println("After Hooks");
//        if(DriverFactory.getDriver() != null) {
//            DriverFactory.quitDriver();
//        }
//
//    }
}
