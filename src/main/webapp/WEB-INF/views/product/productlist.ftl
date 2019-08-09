<html>
<#include "common/header.ftl">


  <body>

  <div id="wrapper" class="toggled">

  <#--边栏sidebar-->
    <#include "common/nav.ftl">

  <#--主要内容content-->
      <div id="page-content-wrapper">
          <div class="container-fluid">
              <div class="row clearfix">
                  <div class="col-md-12 column">
                      <table class="table table-bordered table-condensed">
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
                              </thead>

                              <#list productlist as product>

                                  <tr>
                                      <th>${product.id}</th>
                                      <th>${product.name}</th>
                                      <th>${product.subImages}</th>
                                      <th>${product.categoryId}</th>
                                      <th>${product.price}</th>
                                      <th>${product.stock}</th>
                                      <th>${product.status}</th>
                                      <th>${product.createTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                                      <th>${product.updateTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                                      <th>
                                          <a href="/user/product/update/${product.id}" >修改</a>
                                          <a href="/user/product/delete/${product.id}" >删除</a>
                                      </th>
                                  </tr>

                              </#list>

                          </table>
                  </div>
              </div>
          </div>
      </div>

  </div>

</body>
</html>
