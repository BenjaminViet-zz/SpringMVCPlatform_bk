<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin page</title>
</head>
<body>
Dear <strong>${user.username}</strong>, Welcome to Admin Page.
<a href="<c:url value="/logout.html" />">Logout</a>
<br/><a href="/user/newUser.html">Add new user</a>
</body>
</html>