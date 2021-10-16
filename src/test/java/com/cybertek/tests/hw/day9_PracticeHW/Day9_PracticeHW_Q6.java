package com.cybertek.tests.hw.day9_PracticeHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day9_PracticeHW_Q6 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.tempmailaddress.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void tC01() throws InterruptedException {

        String email = driver.findElement(By.xpath("//span[@id='email']")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mike");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);

        driver.findElement(By.xpath("//button[@class='radius']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='subheader']")).getText(),"Thank you for signing up. Click the button below to return to the home page.");

        driver.get("https://www.tempmailaddress.com/");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='wpcc-btn']")).click();

        String actual = driver.findElement(By.xpath("//td[text()='do-not-reply@practice.cybertekschool.com']")).getText();

        //System.out.println(actual);

        String expected = " do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actual, expected);

        driver.findElement(By.xpath("//td[text()='do-not-reply@practice.cybertekschool.com']")).click();

        String actualFrom = driver.findElement(By.id("odesilatel")).getText();

        String expectedFrom = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actualFrom, expectedFrom);

        String actualSubject = driver.findElement(By.id("predmet")).getText();

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actualSubject, expectedSubject);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }


}
