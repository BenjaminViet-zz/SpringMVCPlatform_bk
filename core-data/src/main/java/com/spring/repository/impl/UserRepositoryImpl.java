package com.spring.repository.impl;

import com.spring.domain.UserEntity;
import com.spring.repository.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/27/16
 * Time: 09:21
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserEntity> fetchBySearchTerm(String term) {

        StringBuilder query = new StringBuilder("FROM UserEntity u WHERE u.userName LIKE :userName");

        return (List<UserEntity>)em.createQuery(query.toString())
                .setParameter("userName", "%" + term + "%")
                .getResultList();
    }
}
