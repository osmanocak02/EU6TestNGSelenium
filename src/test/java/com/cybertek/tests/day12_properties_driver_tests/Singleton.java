package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    private Singleton() {

    }

    private static String str;

    public static String getInstance(){

        if (str==null){
            System.out.println("str is null");
            str="value";
        }else System.out.println("str has value");

        return str;
    }

}
