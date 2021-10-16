package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @Test
    public void test1(){
        System.out.println("first test case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("web driver loading");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("before class loading");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("after class loading");
    }

}
