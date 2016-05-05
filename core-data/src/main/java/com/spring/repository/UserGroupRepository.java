package com.spring.repository;

import com.spring.domain.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long>{

}
