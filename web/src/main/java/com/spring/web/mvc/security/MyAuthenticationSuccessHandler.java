package com.spring.web.mvc.security;

import com.spring.util.AccountTypeEnum;
import com.spring.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/27/16
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    Logger logger = Logger.getLogger(MyAuthenticationSuccessHandler.class);



    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    /**
     * Redirect to the setting default target URL based on user role (permissions in Database).
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);

        if(response.isCommitted()){
            logger.info("Can not redirect!");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /**
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to his/her role.
     * @param authentication
     * @return
     */
    protected String determineTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();

        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }

        if (isDba(roles)) {
            return Constants.DEFAULT_DBA_TARGET_URL;
        } else if (isAdmin(roles)) {
            return Constants.DEFAULT_ADMIN_TARGET_URL;
        } else {
            return Constants.DEFAULT_TARGET_URL;
        }
    }

    private boolean isUser(List<String> roles) {
        if (roles.contains(AccountTypeEnum.USER.getCode())) {
            return true;
        }
        return false;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains(AccountTypeEnum.ADMIN.getCode())) {
            return true;
        }
        return false;
    }

    private boolean isDba(List<String> roles) {
        if (roles.contains(AccountTypeEnum.DB_ADMIN.getCode())) {
            return true;
        }
        return false;
    }
}
