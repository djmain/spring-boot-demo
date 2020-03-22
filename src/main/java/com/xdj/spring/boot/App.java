package com.xdj.spring.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;


@SpringBootApplication(scanBasePackages = "com.xdj.spring.boot")
@Slf4j
public class App
{

    public static void main(String[] args)
    {
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
//        sw.prettyPrint();
//        System.out.println("sw.prettyPrint()~~~~~~~~~~~~~~~~~");
        System.out.println(sw.prettyPrint());
        String sum = sw.shortSummary();
        long total = sw.getTotalTimeMillis();
        log.info("sum:{}, total:{}.", sum, total);
    }
}