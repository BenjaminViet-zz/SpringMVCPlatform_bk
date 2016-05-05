package com.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "UserGroup")
public class UserGroupEntity implements Serializable{

    private static final long serialVersionUID = 8084438878027878591L;

    @Column(name = "UserGroupId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usergroup_seq")
    @SequenceGenerator(name="usergroup_seq", sequenceName="usergroup_seq", allocationSize=1)
    private Long userGroupId;

    @Column(name = "Code")
    @Basic
    private String code;

    @Column(name = "Description")
    @Basic
    private String description;

    @Column(name = "Path")
    @Basic
    private String path;

    @Column(name = "CreatedDate")
    @Basic
    private Timestamp createdDate;

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupEntity that = (UserGroupEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
