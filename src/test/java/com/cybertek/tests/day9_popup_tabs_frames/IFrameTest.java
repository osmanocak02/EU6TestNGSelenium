package com.cybertek.tests.day9_popup_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class IFrameTest {

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

        driver.get("http://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);



    }


}
