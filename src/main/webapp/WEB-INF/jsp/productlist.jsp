<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/6
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
   </head>
  <body>
  <table>
      <thead>
      <th>商品ID</th>
      <th>商品名称</th>
      <th>产品子图</th>
      <th>类别ID</th>
      <th>商品价格</th>
      <th>库存数量</th>
      <th>商品状态</th>
      <th>创建时间</th>
      <th>更新时间</th>
      <th><a href="insert/">增加</a></th>
      </thead>

      <c:forEach items="${productlist}" var="product">

          <tr>
              <th>${product.id}</th>
              <th>${product.name}</th>
              <th>${product.subImages}</th>
              <th>${product.categoryId}</th>
              <th>${product.price}</th>
              <th>${product.stock}</th>
              <th>${product.status}</th>
              <th>${product.createTime}</th>
              <th>${product.updateTime}</th>
              <th>
                  <a href="update/${product.id}" >修改</a>
                  <a href="delete/${product.id}" >删除</a>
              </th>
          </tr>

      </c:forEach>


  </table>
</body>
</html>
