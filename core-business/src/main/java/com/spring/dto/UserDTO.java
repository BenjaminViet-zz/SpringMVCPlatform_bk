package com.spring.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/20/16
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO implements Serializable{

    private static final long serialVersionUID = 5922070780089022668L;

    private Long userId;
    private String userName;
    private String password;
    private String email;
    private UserGroupDTO userGroup;
    private Timestamp createdDate;
    private Integer isActive;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserGroupDTO getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupDTO userGroup) {
        this.userGroup = userGroup;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getActive() {
        return isActive;
    }

    public void setActive(Integer active) {
        isActive = active;
    }
}
