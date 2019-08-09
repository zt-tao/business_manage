<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<form action="" method="post">

    <input type="hidden" name="id" value=""><br/>
    名称<input type="text" name="username" value=""><br/>
    密码<input type="password" name="password" value=""><br/>
    邮箱:<input type="text" name="email" value=""><br/>
    电话:<input type="text" name="phone" value=""><br/>
    密保问题:<input type="text" name="question" value=""><br/>
    密保答案:<input type="password" name="answer" value=""><br/>
    身份:<input type="text" name="role" value=""><br/>
    <input type="submit"  value="增加"><br/>

</form>
</body>
</html>
