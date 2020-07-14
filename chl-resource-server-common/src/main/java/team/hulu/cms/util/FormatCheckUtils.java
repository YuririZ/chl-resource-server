package team.hulu.cms.util;

import org.springframework.util.StringUtils;

/**
 * 格式校验工具类
 *
 * @author yurizhang
 * @date 2020/7/1 14:28
 */
public class FormatCheckUtils {
    /**
     * 匹配邮箱地址正则
     */
    private static String MAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 匹配手机号正则
     */
    private static String PHONE_REGEX = "0?(13|14|15|17|18|19)[0-9]{9}";
    /**
     * 校验邮箱格式
     *
     * @param mail
     * @return
     */
    public static boolean checkMail(String mail){
        if (StringUtils.isEmpty(mail)){
            return false;
        }
        if (mail.matches(MAIL_REGEX)) {
            return true;
        }
        return false;
    }

    /**
     * 校验手机号格式
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone){
        if (StringUtils.isEmpty(phone)){
            return false;
        }
        if (phone.matches(PHONE_REGEX)) {
            return true;
        }
        return false;
    }
}
