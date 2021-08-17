package user.service.impl;

import com.pyjava.shop.user.UserApplication;
import com.pyjava.shop.user.component.MailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@Slf4j
class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendMail() {
        mailService.sendMail("757355084@qq.com", "pyjava-shop验证码", "hello world");
    }
}
