package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");

        WebDriver driver = WebDriverFactory.getDriver(browserType);

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));

        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password"));



    }

}
