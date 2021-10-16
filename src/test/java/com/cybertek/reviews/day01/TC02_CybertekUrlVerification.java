package com.cybertek.reviews.day01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC02_CybertekUrlVerification {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.cybertekschool.com");

        driver.getCurrentUrl();

        if (driver.getCurrentUrl().contains("cybertek")){
            System.out.println(true);
        }

        String title = driver.getTitle();

        System.out.println(title);

    }
}
