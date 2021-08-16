package com.pyjava.shop.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;


/**
 * <p>描述: [功能描述] </p>
 *
 * @author zhaojj11
 * @version v1.0
 * @date 2021/4/20 1:16
 */
@Slf4j
public class CommonUtil {
    /**
     * 获取ip
     *
     * @param request 请求
     * @return IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || Constants.Common.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || Constants.Common.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || Constants.Common.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (Constants.Common.LOCALHOST.equals(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inetAddress;
                    try {
                        inetAddress = InetAddress.getLocalHost();
                        ipAddress = inetAddress.getHostAddress();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            // "***.***.***.***".length()
            // = 15
            if (ipAddress != null && ipAddress.length() > Constants.Number.FIFTEEN) {

                if (ipAddress.indexOf(Constants.Mark.COMMA) > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
            log.error("获取ip异常");
        }
        return ipAddress;
    }


    /**
     * md5加密
     *
     * @param data 字符串
     * @return md5加密后字符串
     */
    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance(Constants.MD5);
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MD5加密异常");
        }
        return null;

    }

    /**
     * 获取指定长度随机数字
     *
     * @param len 长度
     * @return 数字随机数字
     */
    public static String getRandomCode(int len){
        String source = "0123456789";
        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(source.charAt(random.nextInt(9)));
        }
        return stringBuilder.toString();
    }

    /**
     * 获取当前时间戳
     * @return 当前时间戳
     */
    public static Long getCurrentTimestamp(){
        return System.currentTimeMillis();
    }
}
