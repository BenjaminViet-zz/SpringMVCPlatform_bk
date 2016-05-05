package com.spring.web.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/20/16
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
public class SpringUtils {

    public static Object getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return principal;
    }

    public static String getUserName(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
