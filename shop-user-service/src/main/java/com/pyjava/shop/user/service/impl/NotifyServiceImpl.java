package com.pyjava.shop.user.service.impl;

import com.pyjava.shop.entity.Result;
import com.pyjava.shop.enums.RedisKey;
import com.pyjava.shop.enums.ResultCode;
import com.pyjava.shop.enums.SendCodeEnum;
import com.pyjava.shop.user.component.MailService;
import com.pyjava.shop.user.service.NotifyService;
import com.pyjava.shop.util.CommonUtil;
import com.pyjava.shop.util.RegUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/21 1:15
 */
@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {
    /**
     * 验证码邮件标题
     */
    private static final String EMAIL_SUBJECT = "pyjava-shop";
    /**
     * 验证码邮件内容
     */
    private static final String EMAIL_CONTENT = "您的验证码为%s,有效时间是60s";

    @Autowired
    private MailService mailService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Result<Object> sendCode(SendCodeEnum sendCodeEnum, String to) {
        String key = String.format(RedisKey.EMAIL_CODE.getKey(), to);
        String redisValue = redisTemplate.opsForValue().get(key);

        // 如果不为空,判断是否10min内重复发送
        if (StringUtils.isNotBlank(redisValue)) {
            Long ttl = Long.parseLong(redisValue.split("_")[1]);
            // 当前时间戳-验证码时间戳,如果小于有效时间
            if(CommonUtil.getCurrentTimestamp() - ttl < RedisKey.EMAIL_CODE.getTime()){
                log.info("重复发送验证码,时间间隔为{}", CommonUtil.getCurrentTimestamp() - ttl);
                return Result.ofFailure(ResultCode.CODE_LIMITED);
            }
        }
        String code = CommonUtil.getRandomCode(6);
        Long timestamp = CommonUtil.getCurrentTimestamp();
        String value = code + "_" + timestamp;
        redisTemplate.opsForValue().set(key, value, RedisKey.EMAIL_CODE.getTime(), TimeUnit.MILLISECONDS);

        if (RegUtil.isEmail(to)) {
            //邮箱验证码
            mailService.sendMail(to, EMAIL_SUBJECT, String.format(EMAIL_CONTENT, code));
            return Result.ofSuccess();
        }

        return Result.ofFailure(ResultCode.CODE_TO_ERROR);
    }
}
