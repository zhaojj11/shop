package com.pyjava.shop.exception;

import com.pyjava.shop.entity.Result;
import com.pyjava.shop.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @since 2021/8/16
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
