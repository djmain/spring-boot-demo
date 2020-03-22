package com.xdj.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;


@SpringBootApplication(scanBasePackages = "com.xdj.spring.boot")
public class App {

    public static void main(String[] args){
        try
        {
            test();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        SpringApplication.run(App.class, args);
    }

    public static void test() throws InterruptedException
    {
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
        // do something
        Thread.sleep(100);
        sw.stop();
        sw.start("task2");
        // do something
        Thread.sleep(200);
        sw.stop();
        System.out.println("sw.prettyPrint()~~~~~~~~~~~~~~~~~");
        System.out.println(sw.prettyPrint());
    }
}