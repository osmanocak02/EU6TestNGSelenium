package com.cybertek.reviews.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_YahooPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.yahoo.com");

        String title = driver.getTitle();

        System.out.println(title);

        if (title.contains("Yahoo")){
            System.out.println("true");
        }else System.out.println("false");

        Thread.sleep(5000);

        driver.close();


    }
}
