package com.example.demo.controller;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;

/**
 * @author zft
 * @date 2019/1/21.
 * btrace 进行java程序的实时监控 性能调优和诊断的利器
 */
@BTrace(unsafe = true)
public class TraceScript {

    @OnExit
    public static void onexit(int code) {
        println("BTrace program exits! with code: " + code);
    }

    @Export
    public static long counter;

    @OnMethod(clazz="com.test.BtraceTest", method="add",
            location=@Location(value=Kind.RETURN))
    public static void m(@Self Object self, int a,int b,@Return int result,@Duration long time) {
        BTraceUtils.println("a"+a+"  b"+b);
        BTraceUtils.println(""+time*1.0/1000+"ms");
        jstack();
        counter++;
    }

    @OnEvent("1")
    public static void setL1() {
        BTraceUtils.println("executor count"+counter);
    }

    @OnMethod(clazz = "com.test.BtraceTest", location = @Location(value = Kind.LINE, line = 22))
    public static void onBind() {
        println("");
    }

    @OnTimer(5000)
    public static void run(){
        BTraceUtils.println("executor count"+counter);
    }
}
