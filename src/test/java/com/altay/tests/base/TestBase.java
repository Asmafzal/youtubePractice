package com.altay.tests.base;

import com.altay.utilities.ConfigurationReader;
import com.altay.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();

    }
}
