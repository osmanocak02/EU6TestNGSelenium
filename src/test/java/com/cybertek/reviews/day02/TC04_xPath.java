package com.cybertek.reviews.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC04_xPath {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.manage().window().maximize();

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));

        button1.click();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedText = "Clicked on button one!";

        String actualText = resultText.getText();

        if (expectedText.equalsIgnoreCase(actualText)){
            System.out.println("PASS");
        }else System.out.println("FAIL");

        driver.close();


    }
}
