<html>
<#include  "common/header.ftl">


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
                        <th>类别Id</th>
                        <th>类别名称</th>
                        <th>所属父类</th>
                        <th>类别状态</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                        <th>操作</th>
                        </thead>

                        <#list categorylist as category>
                            <tr>
                                <th>${category.id}</th>
                                <th>${category.name}</th>
                                <th>${category.parentId}</th>
                                <th>${category.status}</th>
                                <th>${category.createTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                                <th>${category.updateTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                                <th>
                                    <a href="/user/category/update/${category.id}" >修改</a>
                                    <a href="/user/category/delete/${category.id}" >删除</a>

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
