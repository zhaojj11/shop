package com.pyjava.shop.util;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/20 12:31
 */
public class Constants {
    public static final String MD5 = "MD5";

    public interface Validity{
        /**
         *临时使用10分钟有效，方便测试
         */
        long CAPTCHA_CODE_EXPIRED = 60 * 1000 * 10;
    }

    public interface Common {
        String UNKNOWN = "unknown";
        String LOCALHOST = "127.0.0.1";
    }

    public interface Mark{
        String COMMA = ",";
        String COLON = ":";
    }
    public interface Number{
        Integer FIFTEEN = 15;
    }
}
