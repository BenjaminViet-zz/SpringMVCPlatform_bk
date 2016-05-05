<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>Add New User</title>
    <link href="/sc-content/css/bootstrap_v1.0.css" type="text/css" rel="stylesheet" />
    <link href="/sc-content/css/style_v1.0.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>

<c:url var="addNewUserUrl" value="/user/newUser.html" />

<div class="form-container">
    <c:choose>
        <c:when test="${not empty insert_success && insert_success}">
            <div class="success">
                Confirmation message : ${success}
                <br>
                Would you like to <a href="${addNewUserUrl}">Add More Users</a>?
                <br/>
                Go to <a href="<c:url value='/admin.html' />">Admin Page</a> OR <a href="<c:url value="/logout.html" />">Logout</a>
            </div>
        </c:when>
        <c:otherwise>
            <h1>New User Registration Form</h1>

            <form:form commandName="item" action="${addNewUserUrl}" method="POST" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="userName">User Name</label>
                        <div class="col-md-7">
                            <form:input type="text" path="pojo.userName" id="userName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors for="userName" path="pojo.userName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="password">Password</label>
                        <div class="col-md-7">
                            <form:input type="password" path="pojo.password" id="password" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="pojo.password" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="userGroup">Group</label>
                        <div class="col-md-7">
                            <form:select id="userGroup" path="pojo.userGroup.userGroupId" cssClass="form-control input-sm">
                                <form:option value="">--Select One--</form:option>
                                <form:options items="${userGroupList}" itemValue="userGroupId" itemLabel="description" />
                            </form:select>
                            <div class="has-error">
                                <form:errors path="pojo.userGroup.userGroupId" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="email">Email</label>
                        <div class="col-md-7">
                            <form:input type="text" path="pojo.email" id="email" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors for="email" path="pojo.email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Register" class="btn btn-primary btn-sm">
                    </div>
                </div>

                <input type="hidden" name="crudaction" value="insert-update" />
            </form:form>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>