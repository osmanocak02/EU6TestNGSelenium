package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssortionsDemo {

    @Test
    public void test1(){
        Assert.assertEquals("title","title");

        Assert.assertEquals("url", "url");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("web driver loading");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser");
    }
}
