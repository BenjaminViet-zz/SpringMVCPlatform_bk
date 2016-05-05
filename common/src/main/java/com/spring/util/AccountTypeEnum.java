package com.spring.util;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/27/16
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public enum AccountTypeEnum {
    DB_ADMIN(0, "DBA", "Database Admin")
    , ADMIN(1, "ADMIN", "System Admin")
    , USER(2, "USER",  "Normal User");

    private Integer value;
    private String code;
    private String label;

    private AccountTypeEnum(Integer value, String code, String label){
        this.value = value;
        this.code = code;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public static Integer getValue(String label) {
        switch (label){
            case "Database Admin":
                return DB_ADMIN.value;
            case "System Admin":
                return ADMIN.value;
            default:
                return USER.value;
        }
    }

    public String getLabel() {
        return label;
    }

    public static String getLabel(Integer value){
        switch (value){
            case 1:
                return DB_ADMIN.label;
            case 2:
                return ADMIN.label;
            default:
                return USER.label;
        }
    }

    public String getCode() {
        return code;
    }
}
