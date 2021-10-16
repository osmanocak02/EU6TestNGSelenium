package com.cybertek.tests.day10_actionsjs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }


    @Test
    public void upload(){

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String projectPath = System.getProperty("user.dir");

        System.out.println("projectPath = " + projectPath);

        String filePath = "src\\test\\resources\\file.txt";

        String fullPath = projectPath+"\\"+filePath;

        System.out.println(fullPath);

        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, "file.txt");

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));


    }

}
