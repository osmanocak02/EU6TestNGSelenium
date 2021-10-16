package com.cybertek.tests.hw.day9_PracticeHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Day9_PracticeHW_Q9_12 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Status Codes")).click();

    }

    @Test
    public void tC09() throws InterruptedException {

        driver.findElement(By.linkText("200")).click();

        Thread.sleep(2000);

        String expected = "This page returned a 200 status code.";

        String actual = driver.findElement(By.xpath("//p[contains(text(), 'This page returned a 200 status code.')]")).getText().substring(0,37);

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void tC10() throws InterruptedException {

        driver.findElement(By.linkText("301")).click();

        Thread.sleep(2000);

        String expected = "This page returned a 301 status code.";

        String actual = driver.findElement(By.xpath("//p[contains(text(), 'This page returned a 301 status code.')]")).getText().substring(0,37);

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void tC11() throws InterruptedException {

        driver.findElement(By.linkText("404")).click();

        Thread.sleep(2000);

        String expected = "This page returned a 404 status code.";

        String actual = driver.findElement(By.xpath("//p[contains(text(), 'This page returned a 404 status code.')]")).getText().substring(0,37);

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void tC12() throws InterruptedException {

        driver.findElement(By.linkText("500")).click();

        Thread.sleep(2000);

        String expected = "This page returned a 500 status code.";

        String actual = driver.findElement(By.xpath("//p[contains(text(), 'This page returned a 500 status code.')]")).getText().substring(0,37);

        Assert.assertEquals(actual, expected);

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
}
