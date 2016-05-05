package com.spring.util;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/27/16
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class Constants {

    // Roles
    public static final String LOGON = "LOGON";
    public static final String ADMIN = "ADMIN";
    public static final String DB_ADMIN = "DB_ADMIN";

    // Default target suffix url
    public static final String DEFAULT_TARGET_URL = "/welcome.html";
    public static final String DEFAULT_ADMIN_TARGET_URL = "/admin.html";
    public static final String DEFAULT_DBA_TARGET_URL = "/dba.html";

    /**
     * The request scope attribute that holds the list form
     */
    public static final String LIST_MODEL_KEY = "items";

    /**
     * The request scope attribute that holds the form
     */
    public static final String FORM_MODEL_KEY = "item";

    /**
     * Acegi security constants
     */

    public static final String ACEGI_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String ACEGI_SECURITY_FORM_PASSWORD_KEY = "password";
    public static final String ACEGI_SECURITY_LAST_USERNAME_KEY = "ACEGI_SECURITY_LAST_USERNAME";

    /**
     * CRUD commands
     */
    public static final String INSERT_UPDATE = "insert-update";
    public static final String DELETE = "delete";
    public static final String EXPORT = "export";
}
