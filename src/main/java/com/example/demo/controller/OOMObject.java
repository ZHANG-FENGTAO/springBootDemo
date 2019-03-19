package com.example.demo.controller;

import java.util.Random;

/**
 * @author zft
 * @date 2019/1/21.
 */
public class OOMObject {

    public static Random random = new Random();
    public int size;

    public static void main(String[] args) throws Exception {
        new OOMObject().run();
    }

    public void run() throws Exception {
        while (true) {
            add(random.nextInt(10), random.nextInt(10));
        }
    }

    public int add(int a, int b) throws Exception {
        Thread.sleep(random.nextInt(10) * 100);
        return a + b;
    }

}
