package com.xdj.spring.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * created by Jay on 2019/6/17
 */
@Component
public class UserService implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("running");
    }
}
