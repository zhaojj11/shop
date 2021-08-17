package com.pyjava.shop.enums;

import com.pyjava.shop.util.Constants;
import lombok.Getter;
import lombok.Setter;

import static com.pyjava.shop.util.Constants.Mark.COLON;

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
     * key为 user:captcha:%s
     * 值为  xx
     */
    CAPTCHA_CODE("user", "captcha", "%s", Constants.Validity.CAPTCHA_CODE_EXPIRED),
    EMAIL_CODE("user", "user_register", "%s", Constants.Validity.CAPTCHA_CODE_EXPIRED);

    /**
     * redis key 所属模块
     */
    private final String module;
    /**
     * redis key 功能名称
     */
    private final String func;
    /**
     * redis key 前缀
     */
    private final String value;

    /**
     * 有效期
     */
    @Setter
    @Getter
    private Long time;

    RedisKey(String module, String func, String value, Long time) {
        this.module = module;
        this.func = func;
        this.value = value;
        this.time = time;
    }

    /**
     * <p>描述: 获取key</p>
     *
     * @return {@link java.lang.String} key module:func:value
     * @author zhaojj11
     * @since 1.0
     */
    public String getKey() {
        return this.module + COLON + this.func + COLON + this.value;
    }
}
