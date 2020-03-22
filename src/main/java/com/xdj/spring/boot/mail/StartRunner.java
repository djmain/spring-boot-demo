package com.xdj.spring.boot.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * created by Jay on 2019/9/13
 */
@Component
public class StartRunner implements ApplicationRunner
{

    private static final Logger LOGGER = LoggerFactory.getLogger(StartRunner.class);
    @Autowired
    MailService mailService;


    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.println("begin runner.");
//        mailService.sendSimpleMail(new String[]{"xiadijun@126.com"}, "Mic", "China is great.");
        LOGGER.info("send {}, {}", "success", "Jack");
    }
}
