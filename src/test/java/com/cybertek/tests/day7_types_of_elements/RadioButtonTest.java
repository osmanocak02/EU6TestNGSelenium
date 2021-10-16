package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void Test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadio = driver.findElement(By.cssSelector("#blue"));

        WebElement redRadio = driver.findElement(By.id("red"));

        System.out.println("blue is selected = " + blueRadio.isSelected());

        System.out.println("red is selected = " + redRadio.isSelected());

        redRadio.click();;

        Assert.assertTrue(blueRadio.isSelected(), "blue button is selected");

        Assert.assertFalse(redRadio.isSelected(), "red button is not selected");

        Thread.sleep(5000);

        driver.quit();





    }
}
