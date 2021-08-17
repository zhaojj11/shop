package com.pyjava.shop.user.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/21 0:48
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    /**
     * springBoot 提供的邮件发送服务
     */
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendMail(String to, String subject, String content) {
        // 创建邮箱消息对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // 配置邮件发送人
        mailMessage.setFrom(from);

        // 邮件的收件人
        mailMessage.setTo(to);

        // 邮件的主体
        mailMessage.setSubject(subject);

        // 邮件内容
        mailMessage.setText(content);
        mailSender.send(mailMessage);

        log.info("发送邮件成功:{}", mailMessage);
    }
}
