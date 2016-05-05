package com.spring.util;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public enum AccountStateEnum {
    INACTIVE(0, "Inactive"),
    ACTIVE(1, "Active");

    private Integer value;
    private String code;

    private AccountStateEnum(Integer value, String code){
        this.value = value;
        this.code = code;
    }

    public Integer getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }
}
