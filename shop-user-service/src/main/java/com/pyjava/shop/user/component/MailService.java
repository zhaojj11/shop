package com.pyjava.shop.user.component;

/**
 * <p>描述: mail 服务 </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/21 0:46
 */
public interface MailService {

    /**
     * 发送邮件
     *
     * @param to      收件人
     * @param subject 主体
     * @param content 内容
     */
    void sendMail(String to, String subject, String content);
}
