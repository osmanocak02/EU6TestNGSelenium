package com.cybertek.tests.hw.day9_PracticeHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day9_PracticeHW_Q7 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void tC01() throws InterruptedException {

        driver.findElement(By.linkText("File Upload")).click();

        String projectPath = System.getProperty("user.dir");

        String filePath = "src\\test\\resources\\file.txt";

        String fullPath = projectPath + "\\" + filePath;

        driver.findElement(By.id("file-upload")).sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String expectedFileName = "file.txt";

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, expectedFileName);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
}
