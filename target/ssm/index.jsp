<%--
  Created by IntelliJ IDEA.
  User: pactera
  Date: 2020/6/4
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询所有用户信息</a><br>

    <form action="account/save" method="post">
        姓名：<input type="text" name="name"/><br>
        金额：<input type="text" name="money"/><br>
        <input type="submit" value="提交"/><br>
    </form>

</body>
</html>
