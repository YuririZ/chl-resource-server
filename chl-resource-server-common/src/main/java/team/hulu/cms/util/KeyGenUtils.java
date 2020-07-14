package team.hulu.cms.util;

import org.springframework.util.StringUtils;

import java.text.MessageFormat;

/**
 * @author: yurizhang
 * @date: 2020/6/16 10:40 下午
 */
public class KeyGenUtils {
    /**
     * 格式化文本
     * @param pattern
     * @param arguments
     * @return
     */
    public static String generateKey(String pattern, Object ... arguments) {
        Object[] params = null;
        if (arguments != null) {
            params = new String[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                if (arguments[i] != null) {
                    params[i] = arguments[i].toString();
                } else {
                    params[i] = "";
                }
            }
        }
        return MessageFormat.format(pattern, params);
    }

    /**
     * 将字符串 均匀分布在16个hash槽内
     *
     * @param key
     * @param hash
     * @return
     */
    public static int getHashNum(String key, int hash) {
        if (StringUtils.isEmpty(key)) {
            return 0;
        }
        if (hash <= 0) {
            hash = 16;
        }
        return Math.abs(key.hashCode() % hash);
    }

}
