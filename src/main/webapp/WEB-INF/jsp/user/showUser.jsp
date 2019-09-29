<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
</head>
<body>
<div id="editor">
    <p>userName : ${user.name} <a href="${ctx}/logout">退出</a></p>
    <!-- 加载编辑器的容器 -->
    <script id="container" name="content" type="text/plain"></script>
</div>

<script src="${ctx}/ueditor/ueditor.config.js"></script>
<script src="${ctx}/ueditor/ueditor.all.js"></script>
<script src="${ctx}/statics/js/jquery-3.3.1.js"></script>
<script>
    var ue = UE.getEditor('container');

    $("#wef")
</script>

</body>
</html>