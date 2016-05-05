package com.spring.web.mvc.command;

import com.spring.dto.UserDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class UserCommand extends AbstractCommand<UserDTO>{
    public UserCommand(){
        this.pojo = new UserDTO();
    }


}
