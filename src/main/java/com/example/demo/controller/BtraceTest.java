package com.example.demo.controller;

import java.util.Random;

/**
 * @author zft
 * @date 2019/1/21.
 */
public class BtraceTest {
    public static Random random=new Random();

    public int add (int a, int b)   {
        int sum=a+b;
        System.out.println("和："+sum);
        return a+b;
    }

    public void run(){
        try {
            while (true) {
                add(random.nextInt(10), random.nextInt(10));
                Thread.sleep(random.nextInt(10) * 100);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args)     {
        new BtraceTest().run();

    }
}
