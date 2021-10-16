package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.id("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));


    }


}
