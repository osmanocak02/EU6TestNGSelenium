package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/tables");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }


    @Test
    public void printTable() throws InterruptedException {

        System.out.println("driver.findElement(By.xpath(\"//table [@id='table1']\")).getText() = " + driver.findElement(By.xpath("//table [@id='table1']")).getText());

        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

        System.out.println("elements.size() = " + elements.size());

        for (WebElement element : elements) {
            element.getText();
        }

        List<WebElement> elements1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println("elements1.size() = " + elements1.size());

        driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]")).getText();




    }



}
