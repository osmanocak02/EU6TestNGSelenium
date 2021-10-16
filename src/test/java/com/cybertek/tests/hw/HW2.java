package com.cybertek.tests.hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW2 {

    public static void main(String[] args) {
/*
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        4.Print text of a,b,c,e and put some email to d */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));

        System.out.println(home.getText());

        WebElement forgotPassword = driver.findElement(By.xpath("//h2[contains(text(),'Forgot Password')]"));

        System.out.println(forgotPassword.getText());

        WebElement email = driver.findElement(By.xpath("//label[contains(text(),'E-mail')]"));

        System.out.println(email.getText());

        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));

        emailBox.sendKeys("a@yahoo.com");

        System.out.println(emailBox.getAttribute("value"));

        WebElement retrievePassword = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));

        System.out.println(retrievePassword.getText());

        driver.quit();












    }


}
