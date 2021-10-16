package com.cybertek.tests.day8_types_of_element2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select statedropdown = new Select(dropDownElement);

        List<WebElement> options = statedropdown.getOptions();

        System.out.println("options = " + options.size());

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select statedropdown = new Select(dropDownElement);

        String expectedResult = "Select a State";
        String actualResult  = statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult, "verify first selection");

        statedropdown.selectByVisibleText("Virginia");
        expectedResult = "Virginia";
        actualResult = statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult, "verify first selection");

        Thread.sleep(2000);
        statedropdown.selectByIndex(51);
        expectedResult = "Wyoming";
        actualResult = statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult, "verify first selection");

        Thread.sleep(2000);
        statedropdown.selectByValue("TX");
        expectedResult = "Texas";
        actualResult = statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult, expectedResult, "verify first selection");



    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
