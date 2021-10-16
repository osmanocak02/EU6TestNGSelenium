package com.cybertek.tests.hw.day9_PracticeHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day9_PracticeHW_Q8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void tC01() throws InterruptedException {

        driver.findElement(By.linkText("Autocomplete")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.xpath("//strong[.='United States of America']")).click();

        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        String expected = driver.findElement(By.id("result")).getText();

        String actual = "You selected: United States of America";

        Assert.assertEquals(actual, expected);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
}
