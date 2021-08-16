package com.pyjava.shop.enums;

import lombok.Getter;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @since 2021/8/16
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(100000, "成功"),
    INNER_EXCEPTION(500000, "内部异常"),
    /**
     * 通用操作码
     */
    OPS_REPEAT(110001, "重复操作"),

    /**
     * 验证码
     */
    CODE_TO_ERROR(240001, "接收号码不合规"),
    CODE_LIMITED(240002, "验证码发送过快"),
    CODE_ERROR(240003, "验证码错误"),
    CODE_CAPTCHA(240101, "图形验证码错误"),

    /**
     * 账号
     */
    ACCOUNT_REPEAT(250001, "账号已经存在"),
    ACCOUNT_UNREGISTER(250002, "账号不存在"),
    ACCOUNT_PWD_ERROR(250003, "账号或者密码错误");

    @Getter
    private final String message;

    @Getter
    private final int code;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

