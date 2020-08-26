<%--
  Created by IntelliJ IDEA.
  User: 春夏冬
  Date: 2020/8/25
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/college/message/updateMessage" method="post">
    <input type="hidden" name="messageId" value="${Qmessage.messageId}">
    <input type="text" name="messageTitle" value="${Qmessage.messageTitle}">标题
    <input type="text" name="messageType" value="${Qmessage.messageType}">类别
    <input type="submit" value="提交">
</form>
</body>
</html>
