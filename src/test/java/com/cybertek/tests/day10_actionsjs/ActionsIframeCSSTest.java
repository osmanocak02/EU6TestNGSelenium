package com.cybertek.tests.day10_actionsjs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsIframeCSSTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void tC01() throws InterruptedException {

        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.id("demo"));

        Actions actions = new Actions(driver);

        actions.doubleClick(text).perform();

        String att = text.getAttribute("style");

        Assert.assertTrue(att.contains("red"));





    }



}
