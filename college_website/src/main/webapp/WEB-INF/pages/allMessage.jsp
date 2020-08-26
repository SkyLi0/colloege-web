<%--
  Created by IntelliJ IDEA.
  User: 春夏冬
  Date: 2020/8/25
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${allMessage}
<hr/>
<a href="${pageContext.request.contextPath}/college/message/toAddMessage">增加</a>
<a href="${pageContext.request.contextPath}/college/message/toUpdateMessage?id=${allMessage.get(3).messageId}">修改</a>
</body>
</html>
