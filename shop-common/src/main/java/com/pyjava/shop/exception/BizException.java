package com.pyjava.shop.exception;

import com.pyjava.shop.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/8/16 11:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {
    private Integer code;
    private String message;

    public BizException(Integer code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(ResultCode resultCode){
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}
