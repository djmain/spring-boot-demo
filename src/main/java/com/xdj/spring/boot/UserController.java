package com.xdj.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by Jay on 2019/9/1
 */
@RestController
public class UserController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public String get()
    {
        LOGGER.info("hello, log--info");
        return "Hello, DJ";
    }
}
