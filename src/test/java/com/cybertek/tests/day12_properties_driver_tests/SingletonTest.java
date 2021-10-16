package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {


    @Test
    public void test1(){
        WebDriver driver = Driver.get();

        driver.get(ConfigurationReader.get("url"));

    }



}
