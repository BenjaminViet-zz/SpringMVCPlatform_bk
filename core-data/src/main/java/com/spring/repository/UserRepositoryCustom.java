package com.spring.repository;

import com.spring.domain.UserEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/27/16
 * Time: 09:12
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepositoryCustom {

    List<UserEntity> fetchBySearchTerm(String term);
}
