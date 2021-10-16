package com.cybertek.tests.hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.demoblaze.com/index.html");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void tC01() throws InterruptedException {

        WebElement laptop = driver.findElement(By.linkText("Laptops"));

        laptop.click();

        Thread.sleep(3000);

        WebElement sony = driver.findElement(By.linkText("Sony vaio i5"));

        sony.click();

        driver.findElement(By.linkText("Add to cart")).click();

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        alert.accept();


        Thread.sleep(5000);

        driver.findElement(By.partialLinkText("Home")).click();

        driver.findElement(By.linkText("Laptops")).click();

        Thread.sleep(3000);

        driver.findElement(By.linkText("Dell i7 8gb")).click();

        driver.findElement(By.linkText("Add to cart")).click();

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();

        alert2.accept();


        driver.findElement(By.linkText("Cart")).click();

        driver.findElement(By.xpath("//tbody/tr/td[.='Dell i7 8gb']/../td[4]/a")).click();


        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("name")).sendKeys("Mike");

        driver.findElement(By.id("country")).sendKeys("UK");

        driver.findElement(By.id("city")).sendKeys("Liverpool");

        driver.findElement(By.id("card")).sendKeys("5555");

        driver.findElement(By.id("month")).sendKeys("June");

        driver.findElement(By.id("year")).sendKeys("2001");

        driver.findElement(By.xpath("//button[.='Purchase']")).click();

        String[] array = driver.findElement(By.xpath("//p[contains(text(),'Id')]")).getText().split(" ");

        int id = Integer.parseInt(array[1].substring(0,7));

        int expectedAmount = Integer.parseInt(array[2]);

        int actualAmount = 790;

        Assert.assertEquals(actualAmount, expectedAmount, "Verif that amount equals");

        driver.findElement(By.xpath("//button[.='OK']")).click();





    }


}
