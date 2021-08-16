package com.pyjava.shop.entity;

import com.pyjava.shop.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @since 2021/8/16
 */
@Data
public class Result<T> implements Serializable {
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
    private T data;
    /**
     * 时间
     */
    private Long timestamp;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * {@link Result} 构建器
     *
     * @param code    状态码
     * @param message 描述
     * @param data    数据
     * @return {@link Result} 统一返回结果
     */
    public static <T> Result<T> of(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    /**
     * {@link Result} 构建器
     *
     * @param resultCode {@link ResultCode} 状态码枚举类
     * @return {@link Result} 统一返回结果
     */
    public static <T> Result<T> of(ResultCode resultCode) {
        return Result.of(resultCode.getCode(), resultCode.getMessage(), null);
    }

    /**
     * {@link Result} 构建器
     *
     * @param resultCode {@link ResultCode} 状态码枚举类
     * @param data       数据
     * @return {@link Result} 统一返回结果
     */
    public static <T> Result<T> of(ResultCode resultCode, T data) {
        return Result.of(resultCode.getCode(), resultCode.getMessage(), data);
    }


    /**
     * 成功
     *
     * @return {@link Result} 统一返回结果
     */
    public static <T> Result<T> ofSuccess() {
        return Result.of(ResultCode.SUCCESS, null);
    }

    /**
     * 成功 并且携带数据
     *
     * @param object 数据
     * @return {@link Result} 统一返回结果
     */
    public static <T> Result<T> ofSuccess(T object) {
        return Result.of(ResultCode.SUCCESS, object);
    }

    /**
     * 失败
     *
     * @param resultCode {@link ResultCode} 状态码枚举类
     * @return {@link Result} 统一返回结果
     */
    public static <T> Result<T> ofFailure(ResultCode resultCode) {
        return Result.of(resultCode);
    }
}
