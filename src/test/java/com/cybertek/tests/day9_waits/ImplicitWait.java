package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        //Thread.sleep(6000);



        System.out.println("driver.findElement(By.cssSelector(\"#finish\")) = " + driver.findElement(By.cssSelector("#finish")).getText());




    }
}
