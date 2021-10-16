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

public class NoSelectDropdown {


    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));
        
        dropDownElement.click();

        List<WebElement> elements = driver.findElements(By.className("dropdown-item"));

        System.out.println("elements.size() = " + elements.size());

        for (WebElement element : elements) {
            element.getText();
        }

        elements.get(2).click();



    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
