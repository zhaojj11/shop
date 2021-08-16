package com.pyjava.shop.entity;

import com.pyjava.shop.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/8/16 11:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 描述
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    /**
     * 时间
     */
    private Long timestamp;
    /**
     * {@link Result} 构建器
     *
     * @param code    状态码
     * @param message 描述
     * @param data    数据
     * @return {@link Result} 统一返回结果
     */
    public static Result of(Integer code, String message, Object data) {
        return new Result(code, message, data, System.currentTimeMillis());
    }

    /**
     * {@link Result} 构建器
     *
     * @param resultCode {@link ResultCode} 状态码枚举类
     * @return {@link Result} 统一返回结果
     */
    public static Result of(ResultCode resultCode) {
        return Result.of(resultCode.getCode(), resultCode.getMessage(), null);
    }

    /**
     * {@link Result} 构建器
     *
     * @param resultCode {@link ResultCode} 状态码枚举类
     * @param data       数据
     * @return {@link Result} 统一返回结果
     */
    public static Result of(ResultCode resultCode, Object data) {
        return Result.of(resultCode.getCode(), resultCode.getMessage(), data);
    }


    /**
     * 成功
     *
     * @return {@link Result} 统一返回结果
     */
    public static Result ofSuccess() {
        return Result.of(ResultCode.SUCCESS, null);
    }

    /**
     * 成功 并且携带数据
     *
     * @param object 数据
     * @return {@link Result} 统一返回结果
     */
    public static Result ofSuccess(Object object) {
        return Result.of(ResultCode.SUCCESS, object);
    }

    /**
     * 失败
     *
     * @param resultCode {@link ResultCode} 状态码枚举类
     * @return {@link Result} 统一返回结果
     */
    public static Result ofFailure(ResultCode resultCode) {
        return Result.of(resultCode);
    }
}

