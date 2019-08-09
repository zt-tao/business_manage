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
                            <th>用户Id</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>邮箱</th>
                            <th>电话</th>
                            <th>密保问题</th>
                            <th>密保答案</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            </thead>

                        <tbody>
                            <#list userInfoList as userInfo>
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
                                    <a href="/user/update/${userInfo.id}" >修改</a>
                                    <a href="/user/delete/${userInfo.id}" >删除</a>

                                </th>
                            </tr>

                                 </#list>
                        </tbody>


                        </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
