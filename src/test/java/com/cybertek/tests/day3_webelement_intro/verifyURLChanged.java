package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLChanged {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        WebElement emailInputBox = driver.findElement(By.name("email"));

        emailInputBox.sendKeys("a@yahoo.com");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else System.out.println("FAIL");

        driver.quit();

    }
}
