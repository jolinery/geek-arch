package com;

/**
 * @program: pressure
 * @description:
 * @author: zhanglin16
 * @create: 2020-07-13 19:00
 **/
public class Main {
    public static void main(String[] args){
        PressureTest pressureTest = new PressureTest("https://www.baidu.com",20,10);
        pressureTest.testing(95);
    }
}
