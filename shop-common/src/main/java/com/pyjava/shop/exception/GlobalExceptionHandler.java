package com.pyjava.shop.exception;

import com.pyjava.shop.entity.Result;
import com.pyjava.shop.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>描述: 全局异常返回 </p>
 *
 * @author zhaojj11
 * @since 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> exceptionHandler(Exception e) {
        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            log.error("[业务异常 {0}]", e);
            return Result.of(bizException.getCode(), bizException.getMessage(), null);
        } else {
            log.error("[非业务异常 {0}]", e);
            return Result.of(ResultCode.INNER_EXCEPTION);
        }
    }
}
