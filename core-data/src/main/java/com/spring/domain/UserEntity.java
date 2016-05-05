package com.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/13/16
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "Users")
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -9059863720279482191L;

    @Column(name = "UserId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
    private Long userId;

    @Column(name = "UserName")
    @Basic
    private String userName;

    @Column(name = "Password")
    @Basic
    private String password;

    @Column(name = "Email")
    @Basic
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserGroupId", referencedColumnName = "UserGroupId")
    private UserGroupEntity userGroup;

    @Column(name = "CreatedDate")
    @Basic
    private Timestamp createdDate;

    @Column(name = "IsActive")
    @Basic
    private Integer active;

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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
