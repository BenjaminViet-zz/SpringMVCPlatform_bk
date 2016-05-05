package com.spring.domain;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 5/3/16
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Persistent_Logins")
public class PersistentLoginEntity implements Serializable{

    private static final long serialVersionUID = -1992130927832309032L;

    @Column(name = "PersistentLoginId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persistent_login_seq")
    @SequenceGenerator(name="persistent_login_seq", sequenceName="persistent_login_seq", allocationSize=1)
    private Long PersistentLoginId;

    @Column(name = "UserName")
    @Basic
    private String userName;

    @Column(name = "Series")
    @Basic
    private String series;

    @Column(name = "Token")
    @Basic
    private String token;

    @Column(name = "Last_Used")
    @Basic
    private Timestamp lastUsed;

    public PersistentLoginEntity(){

    }

    public PersistentLoginEntity(PersistentRememberMeToken persistentRememberMeToken){
        this.userName = persistentRememberMeToken.getUsername();
        this.series = persistentRememberMeToken.getSeries();
        this.token = persistentRememberMeToken.getTokenValue();
        this.lastUsed = new Timestamp(persistentRememberMeToken.getDate().getTime());
    }

    public Long getPersistentLoginId() {
        return PersistentLoginId;
    }

    public void setPersistentLoginId(Long persistentLoginId) {
        PersistentLoginId = persistentLoginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersistentLoginEntity that = (PersistentLoginEntity) o;

        if (lastUsed != null ? !lastUsed.equals(that.lastUsed) : that.lastUsed != null) return false;
        if (series != null ? !series.equals(that.series) : that.series != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (series != null ? series.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (lastUsed != null ? lastUsed.hashCode() : 0);
        return result;
    }
}
