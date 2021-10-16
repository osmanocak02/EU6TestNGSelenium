package com.cybertek.tests.day9_popup_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Before driver.getTitle() = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)){
                driver.switchTo().window(windowHandle);

            }
        }

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            if (driver.getTitle().equals("New Window")){
               break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // wait.until(ExpectedConditions.visibilityOf(inputBox))



    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
}
