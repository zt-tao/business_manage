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

                        <input type="hidden" name="id" value="${product.id}"><br/>
                        名称<input type="text" name="name" value="${product.name}"><br/>
                        价格<input type="text" name="price" value="${product.price}"><br/>
                        库存:<input type="text" name="stock" value="${product.stock}"><br/>
                        类别ID:<select name="categoryId">
                        <option></option>
                        <#list categoryList as category>
                            <option value="${category.id}">${category.id}</option>
                        </#list>
                    </select><br/>
                        <input type="submit"  value="修改"><br/>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
