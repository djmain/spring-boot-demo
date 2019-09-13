package com.xdj.spring.boot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * created by Jay on 2019/9/13
 */
@Service
public class MailService
{
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;


    /**
     * 常见异常:
     * Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 550
     * 解决方法：需要在发件人邮箱里面开启SMTP服务，并设置客户端登录密码
     * MailSendException: Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 554 DT:SPM 126 smtp1,C8mowACXSvAAgntd0YB4AQ-
     * 解决方法：邮件title和content之前写的是test和hello world等,被网易认为邮件内容不合法
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String[] to, String subject, String content)
    {

        try
        {
            SimpleMailMessage simpleMailMessage = buildSimpleMail(to, subject, content);
            javaMailSender.send(simpleMailMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private SimpleMailMessage buildSimpleMail(String[] to, String subject, String content)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件发送人
        simpleMailMessage.setFrom(from);
        //邮件接收人
        simpleMailMessage.setTo(to);
        //邮件主题
        simpleMailMessage.setSubject(subject);
        //邮件内容
        simpleMailMessage.setText(content);
        return simpleMailMessage;
    }
}
