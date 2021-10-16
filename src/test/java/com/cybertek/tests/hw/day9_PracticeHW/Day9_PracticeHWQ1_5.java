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

import java.util.List;

public class Day9_PracticeHWQ1_5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement registrationLabel = driver.findElement(By.xpath("//a[.='Registration Form']"));

        registrationLabel.click();
    }

    @Test
    public void tC01() {

        WebElement dateOfBirthBox = driver.findElement(By.xpath("//input[@data-bv-field='birthday']"));
        dateOfBirthBox.sendKeys("wrong_dob");

        WebElement dateOfBirthLabel = driver.findElement(By.xpath("//small[@data-bv-for='birthday'][2]"));
        Assert.assertTrue(dateOfBirthLabel.isDisplayed());


    }

    @Test
    public void tC02(){

        WebElement cLabel = driver.findElement(By.cssSelector("#inlineCheckbox1"));
        WebElement cJava = driver.findElement(By.cssSelector("#inlineCheckbox2"));
        WebElement cJavaScript = driver.findElement(By.cssSelector("#inlineCheckbox3"));

        Assert.assertTrue(cLabel.isDisplayed());
        Assert.assertTrue(cJava.isDisplayed());
        Assert.assertTrue(cJavaScript.isDisplayed());

    }

    @Test
    public void tC03(){

        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        firstNameBox.sendKeys("a");

        WebElement firstNameLabel = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]"));

        Assert.assertTrue(firstNameLabel.isDisplayed());

    }

    @Test
    public void tC04(){

        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));

        lastNameBox.sendKeys("a");

        WebElement lastNameLabel = driver.findElement(By.xpath("//small[@data-bv-for='lastname'][2]"));

        Assert.assertTrue(lastNameLabel.isDisplayed());

    }

    @Test
    public void tC05() throws InterruptedException {

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("mike");

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("smith");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("mikesmith");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mikesmith@yahoo.com");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("aA123456");

        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("555-000-0000");

        driver.findElement(By.xpath("//input[@value='male']")).click();

        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/03/1995");

        WebElement elements = driver.findElement(By.xpath("//select[@name='department']"));

        Select department = new Select(elements);

        department.selectByValue("DE");

        WebElement elements2 = driver.findElement(By.xpath("//select[@name='job_title']"));

        Select job = new Select(elements2);

        job.selectByIndex(4);

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(6000);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String expected = "You've successfully completed registration!";

        String actual = driver.findElement(By.xpath("//div/p")).getText();

        Assert.assertEquals(actual,expected);


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
