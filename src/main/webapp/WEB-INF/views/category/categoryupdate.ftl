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

                    <form action="" method="post">

                        <input type="hidden" name="id" value="${category.id}"><br/>
                        名称:<input type="text" name="name" value="${category.name}"><br/>
                        父类id:<select name="parentId">
                        <option></option>
                        <#list categorylist as category>
                            <option value="${category.id}">${category.id}</option>
                        </#list>
                    </select><br/>
                        类别状态:<input type="text" name="status" value="${category.status}"><br/>

                        <input type="submit"  value="修改"><br/>

                    </form>

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
