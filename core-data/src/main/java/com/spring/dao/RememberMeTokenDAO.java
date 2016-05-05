package com.spring.dao;

import com.spring.domain.PersistentLoginEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 5/4/16
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class RememberMeTokenDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String QUERY_PERSISTENT_ENTITY = "SELECT p FROM PersistentLoginEntity p WHERE p.series = :series";

    public void createNewToken(PersistentLoginEntity token) {
        sessionFactory.getCurrentSession().save(token);
    }

    public void updateToken(String series, String tokenValue, Timestamp lastUsed) {
        PersistentLoginEntity existingToken = (PersistentLoginEntity)sessionFactory.getCurrentSession().createQuery(QUERY_PERSISTENT_ENTITY).setParameter("series", series).uniqueResult();

        existingToken.setToken(tokenValue);
        existingToken.setLastUsed(lastUsed);
        sessionFactory.getCurrentSession().merge(existingToken);
    }

    public PersistentLoginEntity getTokenForSeries(String series) {
        return (PersistentLoginEntity) sessionFactory.getCurrentSession().createQuery(QUERY_PERSISTENT_ENTITY).setParameter("series", series).uniqueResult();
    }

    public void removeUserTokens(final String username) {

        PersistentLoginEntity token =
                (PersistentLoginEntity) sessionFactory.getCurrentSession().createCriteria(PersistentLoginEntity.class)
                        .add(Restrictions.eq("username", username)).uniqueResult();
        if (token != null) {
            sessionFactory.getCurrentSession().delete(token);
        }
    }
}
