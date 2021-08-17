package com.pyjava.shop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>描述: 用户服务启动类 </p>
 *
 * @author zhaojj11
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.pyjava.shop")
@MapperScan("com.pyjava.shop.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
