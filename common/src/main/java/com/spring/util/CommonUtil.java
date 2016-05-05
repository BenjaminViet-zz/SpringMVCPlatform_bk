package com.spring.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class CommonUtil {
    private static final Pattern EMAIL_P = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    public static boolean isValidEmail(String email) {
        Matcher m = EMAIL_P.matcher(email);
        return m.matches();
    }
}
