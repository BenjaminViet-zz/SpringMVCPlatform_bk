package com.spring.rememberme;

import com.spring.dao.RememberMeTokenDAO;
import com.spring.domain.PersistentLoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 5/4/16
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */

@Component
public class PersistentLoginRepository implements PersistentTokenRepository{

    @Autowired
    private RememberMeTokenDAO rememberMeTokenDAO;

    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        rememberMeTokenDAO.createNewToken(new PersistentLoginEntity(persistentRememberMeToken));
    }

    @Override
    public void updateToken(String series, String token, Date date) {
        rememberMeTokenDAO.updateToken(series, token, new Timestamp(date.getTime()));
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String series) {
        PersistentLoginEntity persistentLoginEntity = rememberMeTokenDAO.getTokenForSeries(series);
        if(persistentLoginEntity != null){
            return new PersistentRememberMeToken(persistentLoginEntity.getUserName(),persistentLoginEntity.getSeries(), persistentLoginEntity.getToken(), persistentLoginEntity.getLastUsed());
        }
        return null;
    }

    @Override
    public void removeUserTokens(String userName) {
        rememberMeTokenDAO.removeUserTokens(userName);
    }
}
