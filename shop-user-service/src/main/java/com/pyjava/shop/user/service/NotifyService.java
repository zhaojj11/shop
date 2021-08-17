package com.pyjava.shop.user.service;

import com.pyjava.shop.entity.Result;
import com.pyjava.shop.enums.SendCodeEnum;


/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/21 1:14
 */
public interface NotifyService {
    /**
     * 发送验证码
     *
     * @param sendCodeEnum 发送验证码枚举类
     * @param to 用户邮箱
     * @return 统一返回结果
     */
    Result<Object> sendCode(SendCodeEnum sendCodeEnum, String to);
}
