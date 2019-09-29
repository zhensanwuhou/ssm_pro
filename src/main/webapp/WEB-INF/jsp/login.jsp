<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="login" method="post">
        <input type="text" name="username"/>
        <br>
        <input type="password" name="password"/>
        <br>
        <input type="submit" id="sub" value="登录"/>
        <br/>
        ${error}
    </form>
</div>
</body>
</html>