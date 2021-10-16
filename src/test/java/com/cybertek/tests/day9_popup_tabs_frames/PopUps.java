package com.cybertek.tests.day9_popup_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PopUps {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement jsButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        jsButton.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        WebElement jsButton2 = driver.findElement(By.xpath("//button[2]"));
        jsButton2.click();
        Thread.sleep(2000);
        alert.dismiss();

        WebElement jsButton3 = driver.findElement(By.xpath("//button[3]"));
        jsButton3.click();
        Thread.sleep(2000);
        alert.sendKeys("Mike");
        alert.accept();






    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
}
