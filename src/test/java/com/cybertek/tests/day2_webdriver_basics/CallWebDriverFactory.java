package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {

        WebDriver driver = new WebDriverFactory().getDriver("chrome");


    }
}
