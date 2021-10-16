package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement check1 = driver.findElement(By.id("box1"));

        WebElement check2 = driver.findElement(By.id("box2"));

        System.out.println("check1.isSelected() = " + check1.isSelected());

        System.out.println("check2.isSelected() = " + check2.isSelected());

        Assert.assertFalse(check1.isSelected(), "verify check1 is not selected");

        Assert.assertTrue(check2.isSelected(), "verify check2 is selected");

        driver.quit();

    }
}
