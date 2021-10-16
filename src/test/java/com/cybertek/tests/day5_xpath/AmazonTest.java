package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    /**
     * TASK
     * go to amazon.com
     * search for selenium
     * click search button
     * verify 1-48 of 199 results for "selenium"
     *
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));

        searchText.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));

        searchButton.click();

        WebElement searchText2 = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));

        WebElement searchItemtext = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

        String expected = searchText2.getText() + " " + searchItemtext.getText();

        String actual = "1-48 of 199 results for \"selenium\"";

        if (expected.equalsIgnoreCase(actual)){
            System.out.println("PASS");
            System.out.println("Expected :" + expected );
            System.out.println("Actual :" + actual );
        }else {
            System.out.println("FAIL");
            System.out.println("Expected :" + expected );
            System.out.println("Actual :" + actual );
        }



    }
}
