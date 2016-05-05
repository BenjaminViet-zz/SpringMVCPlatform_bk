package com.spring.repository;

import com.spring.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/20/16
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{

    UserEntity findByUserName(String userName);
}
