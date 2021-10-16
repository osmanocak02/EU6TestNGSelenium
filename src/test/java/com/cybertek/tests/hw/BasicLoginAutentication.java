package com.cybertek.tests.hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicLoginAutentication {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle = driver.getTitle();

        String expectedTitle = "Web Orders Login";

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("PASS");
        }else System.out.println("FAIL");

        WebElement usernameText = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameText.sendKeys("Tester");

        WebElement passwordText = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordText.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        driver.close();


    }
}
