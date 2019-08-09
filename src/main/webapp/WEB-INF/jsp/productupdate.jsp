<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/6
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>修改商品</h1>



<form action="" method="post">

    <input type="hidden" name="id" value="${product.id}"><br/>
    名称<input type="text" name="name" value="${product.name}"><br/>
    价格<input type="text" name="price" value="${product.price}"><br/>
    库存:<input type="text" name="stock" value="${product.stock}"><br/>
    类别ID:<select name="categoryId">
                          <option></option>
                      <c:forEach items="${categoryList}" var="category">
                          <option value="${category.id}">${category.id}</option>
                      </c:forEach>
                </select><br/>
    <input type="submit"  value="修改"><br/>

</form>


</body>
</html>
