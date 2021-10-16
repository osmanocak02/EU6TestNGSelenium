package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {


    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenButton = driver.findElement(By.id("green"));

        Assert.assertFalse(greenButton.isEnabled(), "verify that button is not enabled");

        driver.quit();
    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement disabledText = driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(disabledText.isEnabled(), "verify that button is not enabled");

        driver.quit();
    }
}
