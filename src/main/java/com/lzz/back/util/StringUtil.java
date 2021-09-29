package com.lzz.back.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;
/**
 * <p>
 *  加密传输
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
public class StringUtil {
     //MD5加密
    public static String md5(String key){
        if (StringUtils.isBlank(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
    public static Integer changeString(String string){
        if (string != null && !StringUtils.isBlank(string)) {
            return Integer.valueOf(string);
        }else {
            return null;
        }
    }
}
