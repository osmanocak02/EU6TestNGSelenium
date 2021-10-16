package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "a@yahoo.com";

        emailInputBox.sendKeys(expectedEmail);

        String actualEmail = emailInputBox.getAttribute("value");

        System.out.println("expected = " + expectedEmail);

        System.out.println("actual = " + actualEmail);

        if (actualEmail.equals(expectedEmail)){
            System.out.println("Email got PASS");
        }else System.out.println("Email FAIL");

        WebElement emailRetrieveButton = driver.findElement(By.id("form_submit"));

        emailRetrieveButton.click();

        WebElement actualConfirmation = driver.findElement(By.name("confirmation_message"));

        String emailConfirmationText = actualConfirmation.getText();

        String expectedConfirmation = "Your e-mail's been sent!";

        if (emailConfirmationText.equals(expectedConfirmation)){
            System.out.println("Text got PASS");
        }else System.out.println("Text got FAIL");

        driver.quit();





    }
}
