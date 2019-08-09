<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>增加类别</title>
</head>
<body>
<h1>增加类别</h1>



<form action="" method="post">

    <input type="hidden" name="id" value=""><br/>
    名称<input type="text" name="name" value=""><br/>
    <%--父类id<input type="text" name="parentId" value=""><br/>--%>
    父类id:<select name="parentId">
    <option></option>
    <c:forEach items="${categorylist}" var="category">
        <option value="${category.id}">${category.id}</option>
    </c:forEach>
</select><br/>
    类别状态:<input type="text" name="status" value=""><br/>
    <input type="submit"  value="增加"><br/>

</form>

</body>
</html>
