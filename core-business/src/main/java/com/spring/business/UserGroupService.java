package com.spring.business;

import com.spring.dto.UserGroupDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public interface UserGroupService {
    List<UserGroupDTO> findAll();
}
