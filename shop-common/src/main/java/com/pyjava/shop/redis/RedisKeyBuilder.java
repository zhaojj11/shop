package com.pyjava.shop.redis;

import com.pyjava.shop.enums.RedisKey;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @since 1.0
 */
public class RedisKeyBuilder {
    public static String build(RedisKey redisKey, String value){
        return String.format(redisKey.getKey(), value);
    }
}
