package com.cybertek.tests.hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxHW {

    @Test
    public void tC2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement check1 = driver.findElement(By.id("isAgeSelected"));

        Assert.assertFalse(check1.isSelected(), "Success – Check box is checked NOT displayed");

        System.out.println("check1.isSelected() = " + check1.isSelected());

        check1.click();

        Assert.assertTrue(check1.isSelected(), "Success – Check box is checked is displayed");

        System.out.println("check1.isSelected() = " + check1.isSelected());

        driver.quit();
    }

    @Test
    public void tC3(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement check1 = driver.findElement(By.id("check1"));

        Assert.assertTrue(check1.getAttribute("value").equals("Check All"));

        check1.click();

        Assert.assertTrue(check1.getAttribute("value").equals("Uncheck All"));

        driver.quit();

    }

}
