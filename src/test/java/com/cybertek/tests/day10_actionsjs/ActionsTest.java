package com.cybertek.tests.day10_actionsjs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {

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
    public void hoverTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);

        Thread.sleep(3000);

        actions.moveToElement(img1).perform();

        //actions.sendKeys(Keys.PAGE_UP).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(), "link if displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement  target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //actions.dragAndDrop(source, target).perform();

        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();

    }

}
