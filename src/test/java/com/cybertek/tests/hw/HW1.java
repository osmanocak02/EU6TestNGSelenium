package com.cybertek.tests.hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Locale;

public class HW1 {

    public static void main(String[] args) throws InterruptedException {

        //tC1();
        //tC2();
        tC3();

    }

        public static void tC1() throws InterruptedException {

            WebDriver driver = WebDriverFactory.getDriver("chrome");

            driver.get("https://www.ebay.com/");

            WebElement searchText = driver.findElement(By.id("gh-ac"));

            searchText.sendKeys("java");

            WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));

            searchButton.click();

            WebElement resultText = driver.findElement(By.xpath("//*[@class='srp-controls__count-heading']/span[1]"));

            String result = resultText.getText();

            System.out.println(result);

            Thread.sleep(10000);

            driver.close();

        }

        public static void tC2() throws InterruptedException {

            WebDriver driver = WebDriverFactory.getDriver("chrome");

            driver.get("https://www.ebay.com/");

            WebElement searchText = driver.findElement(By.id("gh-ac"));

            searchText.sendKeys("selenium");

            WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));

            searchButton.click();

            if (driver.getTitle().contains("selenium")){
                System.out.println("Title contains selenium");
            }else System.out.println("Title does not contain selenium");

            Thread.sleep(5000);

            driver.close();

        }

        public static void tC3() throws InterruptedException {

            //Go to wikipedia.org (Links to an external site.)
            //enter search term `selenium webdriver`
            //click on search button
            //click on search result `Selenium (software)`
            //verify url ends with `Selenium_(software)'

            WebDriver driver = WebDriverFactory.getDriver("chrome");

            driver.get("https://www.wikipedia.org");

            WebElement searchText = driver.findElement(By.cssSelector("input[id='searchInput']"));

            searchText.sendKeys("selenium webdriver");

            WebElement searchButton = driver.findElement(By.cssSelector("i[class='sprite svg-search-icon']"));

            WebElement langSelector = driver.findElement(By.cssSelector("option[value='en']"));

            langSelector.click();

            searchButton.click();

            WebElement searchText2 = driver.findElement(By.xpath("//a[@title='Selenium (software)']"));

            searchText2.click();

            if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
                System.out.println("URL ends with Selenium_(software)");
            }else System.out.println("URL does not end with Selenium_(software)");

            Thread.sleep(5000);

            driver.close();

        }



}
