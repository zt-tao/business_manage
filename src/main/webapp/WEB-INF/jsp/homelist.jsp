<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h1>欢迎,${user.username}登录</h1>
<table>
    <thead>
    <th>用户Id</th>
    <th>用户名</th>
    <th>密码</th>
    <th>邮箱</th>
    <th>电话</th>
    <th>密保问题</th>
    <th>密保答案</th>
    <th>创建时间</th>
    <th>更新时间</th>
    <th><a href="insert/">增加</a></th>
    </thead>

    <c:forEach items="${userInfoList}" var="userInfo">
        <tr>
            <th>${userInfo.id}</th>
            <th>${userInfo.username}</th>
            <th>${userInfo.password}</th>
            <th>${userInfo.email}</th>
            <th>${userInfo.phone}</th>
            <th>${userInfo.question}</th>
            <th>${userInfo.answer}</th>
            <th>${userInfo.createTime}</th>
            <th>${userInfo.updateTime}</th>
            <th>
                <a href="update/${userInfo.id}" >修改</a>
                <a href="delete/${userInfo.id}" >删除</a>

            </th>
        </tr>

    </c:forEach>


</table>


</body>
</html>
