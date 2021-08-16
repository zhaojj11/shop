package com.pyjava.shop.enums;

import com.pyjava.shop.util.Constants;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>描述: 统一Redis Key管理</p>
 * 在使用是请通过
 * <code>
 * String.format(XXX.getKey(),"a","b",...)
 * </code>
 * 使用
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/20 12:40
 */
public enum RedisKey {

    /**
     * 图形验证码 redis key 格式如下
     * key为 user:captcha:%d
     * 值为  xx
     */
    CAPTCHA_CODE("user", "captcha", "%s", Constants.Validity.CAPTCHA_CODE_EXPIRED),

    EMAIL_CODE("user", SendCodeEnum.USER_REGISTER.toString(), "%s", Constants.Validity.CAPTCHA_CODE_EXPIRED);
    /**
     * redis key 所属模块
     */
    private final String module;
    /**
     * redis key 前缀
     */
    private final String prefix;
    /**
     * redis key后半段值
     */
    private final String value;
    /**
     * 有效期
     */
    @Setter
    @Getter
    private Long time;

    RedisKey(String module, String prefix, String value, Long time) {
        this.module = module;
        this.prefix = prefix;
        this.value = value;
        this.time = time;
    }

    /**
     * 获取key
     *
     * @return key xxx:xxx:%s
     */
    public String getKey() {
        return this.module + Constants.Mark.COLON + this.prefix + Constants.Mark.COLON + this.value;
    }
}
