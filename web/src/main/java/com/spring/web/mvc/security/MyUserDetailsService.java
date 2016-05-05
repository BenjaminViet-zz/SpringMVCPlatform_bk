package com.spring.web.mvc.security;

import com.spring.business.UserService;
import com.spring.dto.UserDTO;
import com.spring.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/17/16
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */

@Service("myUserDetailService")
public class MyUserDetailsService implements UserDetailsService{

    private transient final Logger logger = Logger.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDTO account = (UserDTO)userService.findByUserName(userName);
        if(account == null){
            logger.error("Authentication failed! Could not find the User by userName: " + userName);
            throw new UsernameNotFoundException("User name not found!");
        }
        return new User(account.getUserName(), account.getPassword(), true, true, true, true, authorizeUser(account));
    }

    private List<GrantedAuthority> authorizeUser(UserDTO account){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(Constants.LOGON));
        authorities.add(new SimpleGrantedAuthority(Constants.ADMIN));

        return authorities;
    }
}
