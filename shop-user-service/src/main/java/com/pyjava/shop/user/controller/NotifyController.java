package com.pyjava.shop.user.controller;

import com.google.code.kaptcha.Producer;
import com.pyjava.shop.enums.RedisKey;
import com.pyjava.shop.redis.RedisKeyBuilder;
import com.pyjava.shop.util.CommonUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.pyjava.shop.util.Constants.Request.Headers.USER_AGENT;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @since 1.0
 */
@Api(tags = "通知模块")
@RestController
@RequestMapping("/api/notify/v1/")
@Slf4j
public class NotifyController {

    @Autowired
    @Qualifier("captchaProducer")
    private Producer captchaProducer;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * <p>描述: 获取图形验证码接口 </p>
     * @param request 请求
     * @param response 响应
     * @author zhaojj11
     * @since 1.0
     */
    @GetMapping("captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        String captcha = captchaProducer.createText();
        log.info("图形验证码" + captcha);

        // 存储
        redisTemplate.opsForValue().set(getCaptchaKey(request),
                captcha, RedisKey.CAPTCHA_CODE.getTime(), TimeUnit.MILLISECONDS);

        BufferedImage image = captchaProducer.createImage(captcha);
        ServletOutputStream outputStream;
        try {
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "create_date-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取验证码异常: {}", e.getMessage());
        }
    }

    /**
     * 获取缓存key
     *
     * @param request 请求
     * @return 缓存key
     */
    private String getCaptchaKey(HttpServletRequest request) {
        String ip = CommonUtil.getIpAddr(request);
        String userAgent = request.getHeader(USER_AGENT);
        String key = RedisKeyBuilder.build(RedisKey.CAPTCHA_CODE, CommonUtil.md5(ip + userAgent));
        log.info("ip-{},userAgent-{},key-{}", ip, userAgent, key);
        return key;
    }

}

