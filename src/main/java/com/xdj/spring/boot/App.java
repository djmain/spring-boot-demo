package com.xdj.spring.boot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
//@RestController
public class App {

//    @RequestMapping("/")
//    public String home(){
//        return "hello spring boot!";
//    }

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}