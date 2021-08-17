package com.pyjava.shop.util;

/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @date 1.0
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

    public interface Request{
        interface Headers{
            String X_FORWARDED_FOR = "x-forwarded-for";
            String PROXY_CLIENT_IP = "Proxy-Client-IP";
            String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
            String USER_AGENT = "User-Agent";
        }
    }
}
